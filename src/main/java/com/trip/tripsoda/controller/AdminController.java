package com.trip.tripsoda.controller;

import com.trip.tripsoda.domain.Admin;
import com.trip.tripsoda.dto.AdminRegisterDto;
import com.trip.tripsoda.dto.PageDto;
import com.trip.tripsoda.dto.PageMaker;
import com.trip.tripsoda.service.AdminService;
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
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/list")
    public void list(@ModelAttribute("pageDto") PageDto pageDto, Model model) {
        Pageable pageable = pageDto.makePageable();

        Page<Admin> admins = adminService.getAdminList(pageDto.getCountry(), pageDto.getSize(), pageable);

        model.addAttribute("admins", new PageMaker<>(admins));
    }

    @GetMapping("/register")
    public void register(@ModelAttribute("pageDto")PageDto pageDto) {
        log.info("register...");
    }

    @PostMapping("/register")
    public String registerPost(@Valid AdminRegisterDto adminRegisterDto) {
        Admin admin = dtoToAdmin(adminRegisterDto);
        adminService.register(admin);

        return "redirect:/admin/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        adminService.deleteAdmin(id);

        return "redirect:/admin/list";
    }

    private Admin dtoToAdmin(AdminRegisterDto adminRegisterDto) {
        return Admin.builder()
                .address(adminRegisterDto.getAddress())
                .birth(adminRegisterDto.getBirth())
                .country(adminRegisterDto.getCountry())
                .department(adminRegisterDto.getDepartment())
                .email(adminRegisterDto.getEmail())
                .englishName(adminRegisterDto.getEnglishName())
                .etc(adminRegisterDto.getEtc())
                .job(adminRegisterDto.getJob())
                .joinDate(adminRegisterDto.getJoinDate())
                .password(adminRegisterDto.getPassword())
                .phone(adminRegisterDto.getPhone())
                .name(adminRegisterDto.getName())
                .userid(adminRegisterDto.getUserid())
                .build();
    }
}
