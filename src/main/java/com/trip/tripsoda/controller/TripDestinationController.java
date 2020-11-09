package com.trip.tripsoda.controller;

import com.trip.tripsoda.domain.trip.TripDestination;
import com.trip.tripsoda.dto.FileDto;
import com.trip.tripsoda.dto.PageMaker;
import com.trip.tripsoda.dto.TripDestinationRegisterDto;
import com.trip.tripsoda.dto.TripPageDto;
import com.trip.tripsoda.service.TripDestinationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/trip")
@RequiredArgsConstructor
public class TripDestinationController {

    private final TripDestinationService tripDestinationService;

    @GetMapping("/list")
    public void list(@ModelAttribute("pageDto") TripPageDto pageDto, Model model) {
        log.info("trip list~~~~");
        Pageable pageable = pageDto.makePageable();

        Page<TripDestination> tripDestinations = tripDestinationService.getTripDestinationList(
                pageDto.getCountry(), pageDto.getRegion(), pageDto.getCity(), pageDto.getSize(), pageable);

        model.addAttribute("trips", new PageMaker<>(tripDestinations));
    }

    @GetMapping("/register")
    public void register(@ModelAttribute("pageDto") TripPageDto pageDto,
                         @ModelAttribute("trip") TripDestinationRegisterDto tripDestinationRegisterDto){
        log.info("register...");
        if (tripDestinationRegisterDto.getFileDtos() != null) {
            for (FileDto fileDto : tripDestinationRegisterDto.getFileDtos()) {
                System.out.println(fileDto);
            }
        }
    }

    @GetMapping("/upload")
    public void upload(@ModelAttribute("pageDto") TripPageDto pageDto) {
        log.info("upload get");
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        tripDestinationService.deleteTripDestination(id);

        return "redirect:/trip/list";
    }
}
