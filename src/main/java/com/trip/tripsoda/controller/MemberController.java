package com.trip.tripsoda.controller;

import com.trip.tripsoda.domain.Member;
import com.trip.tripsoda.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/list")
    public void list(Model model) {
        log.info("list..");
        model.addAttribute("members", memberService.getMemberList());
    }

    @GetMapping("/register")
    public void register() {
        log.info("register...");

    }

    @PostMapping("/register")
    public String registerPost(Member member) {
        log.info("member: " + member);
        memberService.joinMember(member);

        return "redirect:/member/list";
    }
}
