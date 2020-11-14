package com.trip.tripsoda.repository.notice;

import com.trip.tripsoda.domain.notice.NoticeFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeFileRepository extends JpaRepository<NoticeFile, String> {
    List<NoticeFile> findByNoticeId(Long noticeId);
}
