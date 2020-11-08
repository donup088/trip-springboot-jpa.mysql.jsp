package com.trip.tripsoda.service;

import com.trip.tripsoda.domain.TripDestination;
import com.trip.tripsoda.repository.trip.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripDestinationService {

    private final TripRepository tripRepository;

    public Page<TripDestination> getTripDestinationList(String country, String address, String city, int size, Pageable pageable) {

        return tripRepository.findAll(country, address, city, size, pageable);
    }
}
