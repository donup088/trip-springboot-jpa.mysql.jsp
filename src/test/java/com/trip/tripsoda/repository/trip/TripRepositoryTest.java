package com.trip.tripsoda.repository.trip;

import com.trip.tripsoda.domain.trip.TripDestination;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
class TripRepositoryTest {

    @Autowired
    private TripRepository tripRepository;

    @Test
    public void 더미데이터생성() {
        for (int i = 0; i < 20; i++) {
            TripDestination tripDestination = new TripDestination();
            tripDestination.setName("김삿갓문학관" + i);
            tripDestination.setCode("M");
            tripDestination.setKorea(true);
            tripDestination.setRegion("강원");
            tripDestination.setCity("영월");
            tripDestination.setEnglish(false);
            tripDestination.setCountry("KOREA");
            tripRepository.save(tripDestination);
        }

        for (int i = 20; i < 40; i++) {
            TripDestination tripDestination = new TripDestination();
            tripDestination.setName("일본지형" + i);
            tripDestination.setCode("N");
            tripDestination.setKorea(true);
            tripDestination.setRegion("강원");
            tripDestination.setCity("영월");
            tripDestination.setEnglish(false);
            tripDestination.setCountry("CHINA");
            tripRepository.save(tripDestination);
        }

        for (int i = 40; i < 60; i++) {
            TripDestination tripDestination = new TripDestination();
            tripDestination.setName("중국지형" + i);
            tripDestination.setCode("C");
            tripDestination.setKorea(true);
            tripDestination.setRegion("강원");
            tripDestination.setCity("영월");
            tripDestination.setEnglish(false);
            tripDestination.setCountry("JAPAN");
            tripRepository.save(tripDestination);
        }
    }
}