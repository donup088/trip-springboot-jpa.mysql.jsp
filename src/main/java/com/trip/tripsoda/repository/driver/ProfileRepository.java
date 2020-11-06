package com.trip.tripsoda.repository.driver;

import com.trip.tripsoda.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,String> {

}
