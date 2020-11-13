package com.trip.tripsoda.repository.admin;

import com.trip.tripsoda.domain.Admin;
import com.trip.tripsoda.domain.notice.Notice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Rollback(value = false)
@Transactional
class AdminRepositoryTest {
    @Autowired
    private AdminRepository adminRepository;

    @Test
    public void 더미데이터생성() {
        for (int i = 0; i < 20; i++) {
            Admin admin = new Admin();
            admin.setUserid("admin" + i);
            admin.setName("관리자" + i);
            admin.setPhone("789-7895" + i);
            admin.setEmail("admin" + i + "@test.com");
            admin.setCountry("KOREA");
            adminRepository.save(admin);
        }

        for (int i = 20; i < 40; i++) {
            Admin admin = new Admin();
            admin.setUserid("admin" + i);
            admin.setName("관리자" + i);
            admin.setPhone("789-7895" + i);
            admin.setEmail("admin" + i + "@test.com");
            admin.setCountry("JAPAN");
            adminRepository.save(admin);
        }

        for (int i = 40; i < 60; i++) {
            Admin admin = new Admin();
            admin.setUserid("admin" + i);
            admin.setName("관리자" + i);
            admin.setPhone("789-7895" + i);
            admin.setEmail("admin" + i + "@test.com");
            admin.setCountry("CHINA");
            adminRepository.save(admin);
        }
    }

    @Test
    public void 공지사항조회테스트(){
        Admin admin = adminRepository.findByUserid("admin58");
        List<Notice> notices = admin.getNotices();
        for (Notice notice : notices) {
            System.out.println("notice = " + notice);
        }
    }
}