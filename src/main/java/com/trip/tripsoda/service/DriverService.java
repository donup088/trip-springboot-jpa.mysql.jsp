package com.trip.tripsoda.service;

import com.trip.tripsoda.domain.Driver;
import com.trip.tripsoda.repository.driver.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;

    public Page<Driver> getDriverList(String country, int size, Pageable pageable) {
        return driverRepository.findAll(country, size, pageable);
    }

    @Transactional
    public void register(Driver driver) {
        driverRepository.save(driver);
    }
}