package com.trip.tripsoda.repository.trip;

import com.trip.tripsoda.domain.trip.TripPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripPhotoRepository extends JpaRepository<TripPhoto,String> {
}
