package com.trip.tripsoda.repository.notice;

import com.trip.tripsoda.domain.Admin;
import com.trip.tripsoda.domain.notice.Notice;
import com.trip.tripsoda.repository.admin.AdminRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@SpringBootTest
@Rollback(value = false)
@Transactional
class NoticeRepositoryTest {
    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Test
    public void 더미데이터생성() {
        Admin admin1 = new Admin();
        admin1.setUserid("TestAdmin1");
        admin1.setName("테스트관리자1");
        admin1.setPhone("789-7895");
        admin1.setEmail("admin1@test.com");
        admin1.setCountry("KOREA");
        adminRepository.save(admin1);

        Admin admin2 = new Admin();
        admin2.setUserid("TestAdmin2");
        admin2.setName("테스트관리자2");
        admin2.setPhone("789-7895");
        admin2.setEmail("admin1@test.com");
        admin2.setCountry("KOREA");
        adminRepository.save(admin2);

        Admin admin3 = new Admin();
        admin3.setUserid("TestAdmin3");
        admin3.setName("테스트관리자3");
        admin3.setPhone("789-7895");
        admin3.setEmail("admin1@test.com");
        admin3.setCountry("KOREA");
        adminRepository.save(admin3);


        for (int i = 0; i < 20; i++) {
            Notice notice = new Notice();
            notice.setAdmin(admin1);
            notice.setCreatedDate(LocalDate.of(2020, 11, 10));
            notice.setTitle("공지사항" + i);
            notice.setCount(0);
            notice.setTop(false);
            notice.setSecret(false);
            noticeRepository.save(notice);
        }

        for (int i = 20; i < 40; i++) {
            Notice notice = new Notice();
            notice.setAdmin(admin2);
            notice.setCreatedDate(LocalDate.of(2020, 11, 13));
            notice.setTitle("공지사항" + i);
            notice.setCount(0);
            notice.setTop(true);
            notice.setSecret(false);
            noticeRepository.save(notice);
        }

        for (int i = 40; i < 60; i++) {
            Notice notice = new Notice();
            notice.setAdmin(admin3);
            notice.setCreatedDate(LocalDate.of(2020, 11, 15));
            notice.setTitle("공지사항" + i);
            notice.setCount(0);
            notice.setTop(false);
            notice.setSecret(true);
            noticeRepository.save(notice);
        }

    }
}