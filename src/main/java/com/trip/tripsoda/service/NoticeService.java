package com.trip.tripsoda.service;

import com.trip.tripsoda.domain.notice.Notice;
import com.trip.tripsoda.domain.notice.NoticeFile;
import com.trip.tripsoda.repository.notice.NoticeFileRepository;
import com.trip.tripsoda.repository.notice.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NoticeService {

    private final NoticeRepository noticeRepository;

    private final NoticeFileRepository noticeFileRepository;

    public Page<Notice> getNoticeList(String title, int size, Pageable pageable) {

        return noticeRepository.findAll(title, size, pageable);
    }


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


    @Transactional
    public void delete(Long id) {
        Notice notice = noticeRepository.findById(id).get();
        List<NoticeFile> noticeFile = notice.getNoticeFile();
        if(noticeFile!=null) {
            for (NoticeFile file : noticeFile) {
                noticeFileRepository.deleteById(file.getUuid());
            }
        }
        noticeRepository.deleteById(id);
    }

    @Transactional
    public Notice getNotice(Long id) {
        Notice notice = noticeRepository.findById(id).get();
        notice.setCount(notice.getCount()+1);

        return notice;
    }
}
