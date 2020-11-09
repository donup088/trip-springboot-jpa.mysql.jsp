package com.trip.tripsoda.repository.trip;

import com.trip.tripsoda.domain.trip.TripDestination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<TripDestination, Long>, TripCustomRepository {

}
