package com.trip.tripsoda.repository.admin;

import com.trip.tripsoda.domain.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

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
}