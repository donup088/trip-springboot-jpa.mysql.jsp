package com.trip.tripsoda.service;

import com.trip.tripsoda.domain.notice.Notice;
import com.trip.tripsoda.repository.notice.NoticeFileRepository;
import com.trip.tripsoda.repository.notice.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final NoticeFileRepository noticeFileRepository;

    public Page<Notice> getNoticeList(String title, int size, Pageable pageable) {

        return noticeRepository.findAll(title, size, pageable);
    }

    //notice 저장 , notice file 저장, admin 쪽에 notice setting
    @Transactional
    public void registerNotice(Notice notice) {
        Notice saveNotice = noticeRepository.save(notice);
        if (notice.getNoticeFile() != null) {
            saveNotice.getNoticeFile().forEach(noticeFile -> {
                noticeFile.setNotice(saveNotice);
                noticeFileRepository.save(noticeFile);
            });
        }
    }
}
