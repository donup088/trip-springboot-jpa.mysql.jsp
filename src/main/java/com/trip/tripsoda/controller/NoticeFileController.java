package com.trip.tripsoda.controller;

import com.trip.tripsoda.domain.notice.NoticeFile;
import com.trip.tripsoda.repository.notice.NoticeFileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class NoticeFileController {
    private final NoticeFileRepository noticeFileRepository;

    @ResponseBody
    @GetMapping("/notice/getFileList")
    public ResponseEntity<List<NoticeFile>> getFileList(@RequestParam("id") Long noticeId) {
        List<NoticeFile> noticeFiles = noticeFileRepository.findByNoticeId(noticeId);

        return new ResponseEntity<>(noticeFiles, HttpStatus.OK);
    }
}
