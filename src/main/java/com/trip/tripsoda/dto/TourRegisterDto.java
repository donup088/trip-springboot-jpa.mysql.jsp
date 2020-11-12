package com.trip.tripsoda.dto;

import lombok.Data;


@Data
public class TourRegisterDto {
    private String name;

    private String country;

    private String city;

    private String region;

    private String tourType;

    private String tourDate;
}
