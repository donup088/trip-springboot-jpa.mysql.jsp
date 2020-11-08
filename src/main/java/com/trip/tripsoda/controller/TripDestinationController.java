package com.trip.tripsoda.controller;

import com.trip.tripsoda.domain.TripDestination;
import com.trip.tripsoda.dto.MemberPageDto;
import com.trip.tripsoda.dto.PageMaker;
import com.trip.tripsoda.dto.TripPageDto;
import com.trip.tripsoda.service.TripDestinationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
                pageDto.getCountry(), pageDto.getAddress(), pageDto.getCity(), pageDto.getSize(), pageable);

        model.addAttribute("trips", new PageMaker<>(tripDestinations));
    }
}
