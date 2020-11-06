package com.trip.tripsoda.repository.driver;

import com.trip.tripsoda.domain.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DriverCustomRepository {
    Page<Driver> findAll(String country, int count, Pageable pageable);
}
