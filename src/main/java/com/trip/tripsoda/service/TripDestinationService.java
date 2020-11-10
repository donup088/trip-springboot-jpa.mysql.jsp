package com.trip.tripsoda.service;

import com.trip.tripsoda.domain.trip.FavoriteTag;
import com.trip.tripsoda.domain.trip.TripDestination;
import com.trip.tripsoda.repository.trip.FavoriteTagRepository;
import com.trip.tripsoda.repository.trip.TripPhotoRepository;
import com.trip.tripsoda.repository.trip.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TripDestinationService {

    private final TripRepository tripRepository;
    private final TripPhotoRepository tripPhotoRepository;
    private final FavoriteTagRepository favoriteTagRepository;

    public Page<TripDestination> getTripDestinationList(String country, String address, String city, int size, Pageable pageable) {

        return tripRepository.findAll(country, address, city, size, pageable);
    }

    public void deleteTripDestination(Long id) {
        tripRepository.deleteById(id);
    }

    @Transactional
    public void register(TripDestination tripDestination) {
        TripDestination saveTripDestination = tripRepository.save(tripDestination);
        FavoriteTag tag = tripDestination.getTag();
        if(tag!=null){
            tag.setTripDestination(saveTripDestination);
            favoriteTagRepository.save(tag);
        }
        if (tripDestination.getTripPhoto() != null) {
            saveTripDestination.getTripPhoto().forEach(tripPhoto -> {
                tripPhoto.setTripDestination(saveTripDestination);
                tripPhotoRepository.save(tripPhoto);
            });
        }
    }
}
