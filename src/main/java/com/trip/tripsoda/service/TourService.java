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

@Service
@RequiredArgsConstructor
public class TourService {

    private final TourRepository tourRepository;

    public Page<Tour> getTourList(String tourDate, int size, String country, String region, String city, String driverName, String tourType, Pageable pageable) {

        return tourRepository.findAll(country, region, city, driverName, tourDate, size, tourType, pageable);
    }
    // member쪽에는 tour 매핑 안해놔서 매핑되어있는 driver쪽에만 setting
    public void register(Tour tour) {
        Tour saveTour = tourRepository.save(tour);
        saveTour.getDriver().getTours().add(saveTour);
    }
}
