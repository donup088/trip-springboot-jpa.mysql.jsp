package com.trip.tripsoda.controller;

import com.trip.tripsoda.domain.Driver;
import com.trip.tripsoda.dto.DriverRegisterDto;
import com.trip.tripsoda.dto.MemberPageDto;
import com.trip.tripsoda.dto.PageMaker;
import com.trip.tripsoda.service.DriverService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/driver")
public class DriverController {

    private final DriverService driverService;

    @GetMapping("/list")
    public void list(@ModelAttribute("pageDto") MemberPageDto memberPageDto, Model model) {
        Pageable pageable = memberPageDto.makePageable();

        Page<Driver> drivers = driverService.getDriverList(memberPageDto.getCountry(), memberPageDto.getSize(), pageable);

        model.addAttribute("drivers", new PageMaker<>(drivers));
    }

    @GetMapping("/register")
    public void register(@ModelAttribute("pageDto") MemberPageDto memberPageDto) {
        log.info("register...");
    }

    @PostMapping("/register")
    public String registerPost(@Valid DriverRegisterDto driverRegisterDto) {
        log.info("driverDto"+driverRegisterDto);
        Driver driver = dtoToDriver(driverRegisterDto);

        driverService.register(driver);

        return "redirect:/driver/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        driverService.deleteDriver(id);

        return "redirect:/driver/list";
    }

    private Driver dtoToDriver(DriverRegisterDto driverRegisterDto) {
        return Driver.builder()
                .driverCount(driverRegisterDto.getDriverCount())
                .address(driverRegisterDto.getAddress())
                .birth(driverRegisterDto.getBirth())
                .car(driverRegisterDto.getCar())
                .carNumber(driverRegisterDto.getCarNumber())
                .country(driverRegisterDto.getCountry())
                .complain(driverRegisterDto.getComplain())
                .department(driverRegisterDto.getDepartment())
                .email(driverRegisterDto.getEmail())
                .etc(driverRegisterDto.getEtc())
                .name(driverRegisterDto.getName())
                .phone(driverRegisterDto.getPhone())
                .region(driverRegisterDto.getRegion())
                .score(driverRegisterDto.getScore())
                .userid(driverRegisterDto.getUserid())
                .profile(driverRegisterDto.getProfile())
                .build();
    }
}
