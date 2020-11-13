package com.trip.tripsoda.repository.tour;

import com.trip.tripsoda.domain.Member;
import com.trip.tripsoda.domain.dirver.Driver;
import com.trip.tripsoda.domain.tour.Tour;
import com.trip.tripsoda.domain.tour.TourAddress;
import com.trip.tripsoda.repository.driver.DriverRepository;
import com.trip.tripsoda.repository.member.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
@Rollback(value = false)
@Transactional
class TourRepositoryTest {
    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void 더미데이터생성() {
        Driver driver1=new Driver();
        driver1.setUserid("driver1");
        driver1.setName("기사회원1");
        driver1.setPhone("567-678");
        driver1.setEmail("driver1@test.com");
        driver1.setCountry("KOREA");
        driverRepository.save(driver1);

        Driver driver2=new Driver();
        driver2.setUserid("driver2");
        driver2.setName("기사회원2");
        driver2.setPhone("567-678");
        driver2.setEmail("driver20@test.com");
        driver2.setCountry("JAPAN");

        driverRepository.save(driver2);

        Driver driver3=new Driver();
        driver3.setUserid("driver03");
        driver3.setName("기사회원3");
        driver3.setPhone("567-678");
        driver3.setEmail("driver3@test.com");
        driver3.setCountry("CHINA");
        driverRepository.save(driver3);

        Member member = new Member();
        member.setUserid("user0" );
        member.setName("일반회원1" );
        member.setPhone("123-123-" );
        member.setEmail("user0@test.com");
        member.setCountry("KOREA");
        memberRepository.save(member);

        Member member2 = new Member();
        member2.setUserid("user2" );
        member2.setName("일반회원2" );
        member2.setPhone("123-123-" );
        member2.setEmail("user2@test.com");
        member2.setCountry("JAPAN");
        memberRepository.save(member2);

        Member member3 = new Member();
        member3.setUserid("user3" );
        member3.setName("일반회원3" );
        member3.setPhone("123-123-" );
        member3.setEmail("user3@test.com");
        member3.setCountry("CHINA");
        memberRepository.save(member3);

        for (int i = 0; i < 10; i++) {
            Tour tour = new Tour();
            tour.setTourDate(LocalDate.of(2020,11,11));
            tour.setCustomer(member);
            tour.setDriver(driver1);
            tour.setAddress(new TourAddress("K","서울","서울"));
            tour.setPersonCount(i+1);
            tour.setTakeTime(i+1);
            tour.setTourType("all");
            tour.setPayment(50000);
            tour.setVisitCount(i+1);
            tour.setFinish(false);
            tourRepository.save(tour);
        }

        for (int i = 10; i < 20; i++) {
            Tour tour = new Tour();
            tour.setTourDate(LocalDate.of(2020,11,10));
            tour.setCustomer(member2);
            tour.setDriver(driver2);
            tour.setAddress(new TourAddress("J","도쿄","도쿄"));
            tour.setPersonCount(i-9);
            tour.setTakeTime(i-9);
            tour.setPayment(30000);
            tour.setTourType("taxi");
            tour.setVisitCount(i-9);
            tour.setFinish(false);
            tourRepository.save(tour);
        }

        for (int i = 20; i < 30; i++) {
            Tour tour = new Tour();
            tour.setTourDate(LocalDate.of(2020,11,12));
            tour.setCustomer(member3);
            tour.setDriver(driver3);
            tour.setAddress(new TourAddress("C","베이징","베이징"));
            tour.setPersonCount(i-19);
            tour.setTakeTime(i-19);
            tour.setTourType("other");
            tour.setPayment(80000);
            tour.setVisitCount(i-19);
            tour.setFinish(true);
            tourRepository.save(tour);
        }
    }
}