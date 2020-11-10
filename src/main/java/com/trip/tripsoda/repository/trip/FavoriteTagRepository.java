package com.trip.tripsoda.repository.trip;

import com.trip.tripsoda.domain.trip.FavoriteTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteTagRepository extends JpaRepository<FavoriteTag, Long> {
}
