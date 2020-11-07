package com.trip.tripsoda.controller;

import com.trip.tripsoda.domain.Member;
import com.trip.tripsoda.dto.MemberRegisterDto;
import com.trip.tripsoda.dto.PageDto;
import com.trip.tripsoda.dto.PageMaker;
import com.trip.tripsoda.service.MemberService;
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
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/list")
    public void list(@ModelAttribute("pageDto") PageDto pageDto, Model model) {
        log.info("list..");
        log.info("pageDto: " + pageDto);
        Pageable pageable = pageDto.makePageable();

        Page<Member> members = memberService.getMemberList(pageDto.getCountry(), pageDto.getSize(), pageable);

        model.addAttribute("members", new PageMaker<>(members));
    }

    @GetMapping("/register")
    public void register(@ModelAttribute("pageDto") PageDto pageDto) {
        log.info("register...");

    }

    @PostMapping("/register")
    public String registerPost(@Valid MemberRegisterDto memberDto) {
        log.info("memberDto: " + memberDto);
        Member member = dtoToMember(memberDto);

        memberService.joinMember(member);

        return "redirect:/member/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        log.info("delete id: " + id);
        memberService.deleteMember(id);

        return "redirect:/member/list";
    }

    private Member dtoToMember(MemberRegisterDto memberDto) {
        return Member.builder()
                .name(memberDto.getName())
                .address(memberDto.getAddress())
                .alias(memberDto.getAlias())
                .country(memberDto.getCountry())
                .birth(memberDto.getBirth())
                .email(memberDto.getEmail())
                .etc(memberDto.getEtc())
                .phone(memberDto.getPhone())
                .password(memberDto.getPassword())
                .emailPost(memberDto.isEmailPost())
                .messagePost(memberDto.isMessagePost())
                .userid(memberDto.getUserid())
                .address(memberDto.getAddress())
                .build();
    }
}
