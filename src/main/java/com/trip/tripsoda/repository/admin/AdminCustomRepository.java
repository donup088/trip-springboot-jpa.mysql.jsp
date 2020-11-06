package com.trip.tripsoda.repository.admin;

import com.trip.tripsoda.domain.Admin;
import com.trip.tripsoda.domain.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminCustomRepository {
    Page<Admin> findAll(String country, int count, Pageable pageable);
}
