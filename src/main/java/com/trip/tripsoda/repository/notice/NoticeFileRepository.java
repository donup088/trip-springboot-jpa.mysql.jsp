package com.trip.tripsoda.repository.notice;

import com.trip.tripsoda.domain.notice.NoticeFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeFileRepository extends JpaRepository<NoticeFile, String> {
}
