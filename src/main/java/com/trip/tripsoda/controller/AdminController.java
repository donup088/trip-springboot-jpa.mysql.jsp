package com.trip.tripsoda.controller;

import com.trip.tripsoda.domain.Admin;
import com.trip.tripsoda.dto.PageDto;
import com.trip.tripsoda.dto.PageMaker;
import com.trip.tripsoda.service.AdminService;
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
    public String registerPost(Admin admin) {
        adminService.register(admin);

        return "redirect:/admin/list";
    }
}
