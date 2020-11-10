package com.trip.tripsoda.repository.tour;

import com.trip.tripsoda.domain.tour.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository  extends JpaRepository<Tour,Long> ,TourCustomRepository{

}
