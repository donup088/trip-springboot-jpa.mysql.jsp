package com.trip.tripsoda.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class TripPhoto {
    @Id
    @Column(name = "trip_photo_uuid", nullable = false)
    private String uuid;

    @Column(name = "uploadPath", nullable = false)
    private String uploadPath;

    @Column(name = "fileName", nullable = false)
    private String fileName;

    @Column(name = "fileType")
    private boolean fileType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_destination_id")
    private TripDestination tripDestination;
}
