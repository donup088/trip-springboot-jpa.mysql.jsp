package com.trip.tripsoda.controller;

import com.trip.tripsoda.domain.Admin;
import com.trip.tripsoda.domain.notice.Notice;
import com.trip.tripsoda.domain.notice.NoticeFile;
import com.trip.tripsoda.dto.FileDto;
import com.trip.tripsoda.dto.PageMaker;
import com.trip.tripsoda.dto.notice.NoticePageDto;
import com.trip.tripsoda.dto.notice.NoticeRegisterDto;
import com.trip.tripsoda.service.AdminService;
import com.trip.tripsoda.service.NoticeService;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

    private final AdminService adminService;

    @GetMapping("/list")
    public void list(@ModelAttribute("pageDto") NoticePageDto noticePageDto, Model model) {
        Pageable pageable = noticePageDto.makePageable();

        Page<Notice> notices = noticeService.getNoticeList(noticePageDto.getTitle(), noticePageDto.getSize(), pageable);

        model.addAttribute("notice", new PageMaker<>(notices));
    }

    @GetMapping("/register")
    public void register(@ModelAttribute("pageDto") NoticePageDto noticePageDto) {
        log.info("register...");

    }

    @PostMapping("/register")
    public String register(NoticeRegisterDto noticeRegisterDto) {
        log.info("notice:" + noticeRegisterDto);
        Notice notice = dtoToNotice(noticeRegisterDto);
        notice.setCreatedDate(LocalDate.now());
        noticeService.registerNotice(notice);

        return "redirect:/notice/list";
    }

    private Notice dtoToNotice(NoticeRegisterDto noticeRegisterDto) {
        Admin admin = adminService.findAdminToNotice(noticeRegisterDto.getAdminDto().getUserid());

        return Notice.builder()
                .content(noticeRegisterDto.getContent())
                .count(noticeRegisterDto.getCount())
                .secret(noticeRegisterDto.isSecret())
                .title(noticeRegisterDto.getTitle())
                .top(noticeRegisterDto.isTop())
                .noticeFile(dtoToNoticeFile(noticeRegisterDto.getFileDtos()))
                .admin(admin)
                .build();
    }

    private List<NoticeFile> dtoToNoticeFile(List<FileDto> fileDtos) {
        List<NoticeFile> noticeFiles = new ArrayList<>();
        if (fileDtos != null) {
            for (FileDto fileDto : fileDtos) {
                NoticeFile noticeFile = new NoticeFile();
                noticeFile.setUuid(fileDto.getUuid());
                noticeFile.setFileName(fileDto.getFileName());
                noticeFile.setFileType(fileDto.isImage());
                noticeFile.setUploadPath(fileDto.getUploadPath());
                noticeFiles.add(noticeFile);
            }
        }
        return noticeFiles;
    }
}
