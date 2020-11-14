package com.trip.tripsoda.repository.notice;

import com.trip.tripsoda.domain.notice.NoticeFile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Rollback(value = false)
@Transactional
class NoticeFileRepositoryTest {
    @Autowired
    private NoticeFileRepository noticeFileRepository;

    @Test
    public void 리스트조회(){
        List<NoticeFile> byNoticeId = noticeFileRepository.findByNoticeId(61L);
        for (NoticeFile noticeFile : byNoticeId) {
            System.out.println("noticeFile = " + noticeFile);
        }
    }
}