package com.trip.tripsoda.repository.trip;

import com.trip.tripsoda.domain.TripDestination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TripCustomRepository {

    Page<TripDestination> findAll(String country, String address, String city, int count, Pageable pageable);
}

