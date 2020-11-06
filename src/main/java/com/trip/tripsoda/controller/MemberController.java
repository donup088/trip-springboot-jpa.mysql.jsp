package com.trip.tripsoda.controller;

import com.trip.tripsoda.domain.Member;
import com.trip.tripsoda.dto.PageDto;
import com.trip.tripsoda.dto.PageMaker;
import com.trip.tripsoda.service.MemberService;
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
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/list")
    public void list(@ModelAttribute("pageDto") PageDto pageDto, Model model) {
        log.info("list..");
        log.info("pageDto: "+pageDto);
        Pageable pageable = pageDto.makePageable();

        Page<Member> members = memberService.getMemberList(pageDto.getCountry(), pageDto.getSize(), pageable);

        model.addAttribute("members", new PageMaker<>(members));
        System.out.println("new PageMaker<>(members) = " + new PageMaker<>(members));
    }

    @GetMapping("/register")
    public void register(@ModelAttribute("pageDto")PageDto pageDto) {
        log.info("register...");

    }

    @PostMapping("/register")
    public String registerPost(Member member) {
        log.info("member: " + member);
        memberService.joinMember(member);

        return "redirect:/member/list";
    }
}