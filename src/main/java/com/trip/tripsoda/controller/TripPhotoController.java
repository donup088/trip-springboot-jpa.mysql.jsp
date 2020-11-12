package com.trip.tripsoda.controller;

import com.trip.tripsoda.dto.FileDto;
import com.trip.tripsoda.dto.TripDestinationRegisterDto;
import com.trip.tripsoda.dto.TripPageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@Slf4j
@RequestMapping("/trip/photo")
public class TripPhotoController {

    @PostMapping("/save")
    public String save(@ModelAttribute("pageDto") TripPageDto pageDto,
                       TripDestinationRegisterDto tripDestinationRegisterDto,
                       RedirectAttributes rttr) {
        log.info("trip photo save get...");
        log.info("pageDto: " + pageDto);
        for (FileDto tripPhoto : tripDestinationRegisterDto.getFileDtos()) {
            System.out.println("tripPhoto = " + tripPhoto);
        }

        rttr.addFlashAttribute("trip",tripDestinationRegisterDto); //객체넘기기

        return "redirect:/trip/register";
    }
}
