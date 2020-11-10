package com.trip.tripsoda.service;

import com.trip.tripsoda.domain.dirver.Driver;
import com.trip.tripsoda.domain.tour.Tour;
import com.trip.tripsoda.repository.tour.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TourService {

    private final TourRepository tourRepository;

    public Page<Tour> getTourList(LocalDateTime tourDate, int size, String country, String region, String city, Driver driver, Pageable pageable) {

        return tourRepository.findAll(country, region, city, driver, tourDate, size, pageable);
    }
}
