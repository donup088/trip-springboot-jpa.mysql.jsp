package com.trip.tripsoda.repository.tour;

import com.trip.tripsoda.domain.dirver.Driver;
import com.trip.tripsoda.domain.tour.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public interface TourCustomRepository {

    Page<Tour> findAll(String country, String region, String city,
                       Driver driver, LocalDateTime tourDate, int count, Pageable pageable);
}
