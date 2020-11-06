package com.trip.tripsoda.controller;

import com.trip.tripsoda.domain.Driver;
import com.trip.tripsoda.dto.PageDto;
import com.trip.tripsoda.dto.PageMaker;
import com.trip.tripsoda.service.DriverService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/driver")
public class DriverController {

    private final DriverService driverService;

    @GetMapping("/list")
    public void list(@ModelAttribute("pageDto") PageDto pageDto, Model model) {
        log.info("pageDto: "+pageDto);
        Pageable pageable = pageDto.makePageable();

        Page<Driver> drivers = driverService.getDriverList(pageDto.getCountry(), pageDto.getSize(), pageable);

        model.addAttribute("drivers", new PageMaker<>(drivers));
        System.out.println("new PageMaker<>(members) = " + new PageMaker<>(drivers));
    }

    @GetMapping("/register")
    public void register(@ModelAttribute("pageDto")PageDto pageDto) {
        log.info("register...");

    }

    @PostMapping("/register")
    public String registerPost(Driver driver) {
        log.info("driver: " + driver);
        driverService.register(driver);

        return "redirect:/driver/list";
    }
}
