package com.trip.tripsoda.service;

import com.trip.tripsoda.domain.Member;
import com.trip.tripsoda.domain.dirver.Driver;
import com.trip.tripsoda.domain.tour.Tour;
import com.trip.tripsoda.repository.driver.DriverRepository;
import com.trip.tripsoda.repository.member.MemberRepository;
import com.trip.tripsoda.repository.tour.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TourService {

    private final TourRepository tourRepository;
    private final MemberRepository memberRepository;
    private final DriverRepository driverRepository;


    public Page<Tour> getTourList(String tourDate, int size, String country, String region, String city, String driverName, String tourType, Pageable pageable) {

        return tourRepository.findAll(country, region, city, driverName, tourDate, size, tourType, pageable);
    }

    // member쪽에는 tour 매핑 안해놔서 매핑되어있는 driver쪽에만 setting
    @Transactional
    public void register(Tour tour) {
        Tour saveTour = tourRepository.save(tour);
        saveTour.getDriver().getTours().add(saveTour);
    }

    @Transactional
    public void deleteTour(Long id) {
        Tour tour = tourRepository.findById(id).get();
        Long driverId = tour.getDriver().getId();
        Long memberId = tour.getCustomer().getId();
        Driver driver = driverRepository.findById(driverId).get();
        Member member = memberRepository.findById(memberId).get();
        int tourCount = member.getTourCount();
        int driverCount = driver.getDriverCount();
        member.setTourCount(tourCount-1);
        driver.setDriverCount(driverCount-1);

        tourRepository.deleteById(id);
    }
}
