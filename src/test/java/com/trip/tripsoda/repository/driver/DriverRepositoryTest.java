package com.trip.tripsoda.repository.driver;

import com.trip.tripsoda.domain.Driver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Rollback(value = false)
@Transactional
class DriverRepositoryTest {

    @Autowired
    private DriverRepository driverRepository;

    @Test
    public void 더미데이터생성() {
        for (int i = 0; i < 20; i++) {
            Driver driver = new Driver();
            driver.setUserid("driver" + i);
            driver.setName("기사회원" + i);
            driver.setPhone("567-678-" + i);
            driver.setEmail("driver" + i + "@test.com");
            driver.setCountry("KOREA");
            driverRepository.save(driver);
        }

        for (int i = 20; i < 40; i++) {
            Driver driver = new Driver();
            driver.setUserid("driver" + i);
            driver.setName("기사회원" + i);
            driver.setPhone("567-678-" + i);
            driver.setEmail("driver" + i + "@test.com");
            driver.setCountry("JAPAN");
            driverRepository.save(driver);
        }

        for (int i = 40; i < 60; i++) {
            Driver driver = new Driver();
            driver.setUserid("driver" + i);
            driver.setName("기사회원" + i);
            driver.setPhone("567-678-" + i);
            driver.setEmail("driver" + i + "@test.com");
            driver.setCountry("CHINA");
            driverRepository.save(driver);
        }
    }
}