package com.trip.tripsoda.repository.tour;

import com.trip.tripsoda.domain.tour.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Date;

public interface TourCustomRepository {

    Page<Tour> findAll(String country, String region, String city,
                       String driverName, String tourDate, int count, String tourType, Pageable pageable);
}
