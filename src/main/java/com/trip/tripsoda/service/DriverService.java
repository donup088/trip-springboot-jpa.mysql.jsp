package com.trip.tripsoda.service;

import com.trip.tripsoda.domain.dirver.Driver;
import com.trip.tripsoda.domain.dirver.Profile;
import com.trip.tripsoda.repository.driver.DriverRepository;
import com.trip.tripsoda.repository.driver.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;

    private final ProfileRepository profileRepository;

    public Page<Driver> getDriverList(String country, int size, Pageable pageable) {
        return driverRepository.findAll(country, size, pageable);
    }

    @Transactional
    public void register(Driver driver) {
        Driver saveDriver = driverRepository.save(driver);
        Profile profile = saveDriver.getProfile();
        profile.setDriver(saveDriver);
        profileRepository.save(profile);
    }

    @Transactional
    public void deleteDriver(Long id) {
        Optional<Driver> findDriver = driverRepository.findById(id);
        Profile profile = findDriver.get().getProfile();
        if(profile!=null){
            String uuid=profile.getUuid();
            profileRepository.deleteById(uuid);
        }
        driverRepository.deleteById(id);
    }
}
