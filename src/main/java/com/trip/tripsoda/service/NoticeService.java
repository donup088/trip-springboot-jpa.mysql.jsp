package com.trip.tripsoda.service;

import com.trip.tripsoda.domain.notice.Notice;
import com.trip.tripsoda.repository.notice.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public Page<Notice> getNoticeList(String title, int size, Pageable pageable) {

        return noticeRepository.findAll(title, size, pageable);
    }
}
