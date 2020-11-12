package com.trip.tripsoda.dto.tour;

import lombok.Data;


@Data
public class TourRegisterDto {
    private String name;

    private String country;

    private String city;

    private String region;

    private String tourType;

    private String tourDate;

    private String startTime;

    private int takeTime;

    private int personCount;

    private int visitCount;

    private int payment;

    private String code;

    private String buyType;

    private int buyPay;

    private TourDriverDto driver;

    private TourMemberDto member;
}
