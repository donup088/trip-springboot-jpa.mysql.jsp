package com.trip.tripsoda.controller;

import com.trip.tripsoda.domain.Member;
import com.trip.tripsoda.domain.notice.Notice;
import com.trip.tripsoda.dto.PageMaker;
import com.trip.tripsoda.dto.member.MemberPageDto;
import com.trip.tripsoda.dto.notice.NoticePageDto;
import com.trip.tripsoda.service.NoticeService;
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
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping("/list")
    public void list(@ModelAttribute("pageDto") NoticePageDto noticePageDto, Model model) {
        Pageable pageable = noticePageDto.makePageable();

        Page<Notice> notices = noticeService.getNoticeList(noticePageDto.getTitle(), noticePageDto.getSize(), pageable);

        model.addAttribute("notice", new PageMaker<>(notices));
    }
}
