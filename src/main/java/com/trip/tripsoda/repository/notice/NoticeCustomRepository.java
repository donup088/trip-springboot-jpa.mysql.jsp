package com.trip.tripsoda.repository.notice;

import com.trip.tripsoda.domain.notice.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoticeCustomRepository {
    Page<Notice> findAll(String title, int size, Pageable pageable);
}
