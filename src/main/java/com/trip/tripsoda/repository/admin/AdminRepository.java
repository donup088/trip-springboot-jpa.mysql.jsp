package com.trip.tripsoda.repository.admin;

import com.trip.tripsoda.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> ,AdminCustomRepository{
}
