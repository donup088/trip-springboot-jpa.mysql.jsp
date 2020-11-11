package com.trip.tripsoda.service;

import com.trip.tripsoda.domain.dirver.Driver;
import com.trip.tripsoda.domain.tour.Tour;
import com.trip.tripsoda.repository.tour.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class TourService {

    private final TourRepository tourRepository;

    public Page<Tour> getTourList(String tourDate, int size, String country, String region, String city, String driverName, String tourType, Pageable pageable) {

        return tourRepository.findAll(country, region, city, driverName, tourDate, size, tourType, pageable);
    }
}
