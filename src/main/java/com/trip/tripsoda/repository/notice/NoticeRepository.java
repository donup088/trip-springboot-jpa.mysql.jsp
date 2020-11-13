package com.trip.tripsoda.repository.notice;

import com.trip.tripsoda.domain.notice.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> ,NoticeCustomRepository{
}
