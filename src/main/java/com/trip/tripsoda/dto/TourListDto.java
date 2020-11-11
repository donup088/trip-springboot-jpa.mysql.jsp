//package com.trip.tripsoda.dto;
//
//import com.querydsl.core.annotations.QueryProjection;
//import com.trip.tripsoda.domain.Member;
//import com.trip.tripsoda.domain.dirver.Driver;
//import lombok.Data;
//import lombok.Getter;
//
//
//@Data
//@Getter
//public class TourListDto {
//    private String tourDate;
//
//    private int personCount;
//
//    private int payment;
//
//    private int takeTime;
//
//    private int visitCount;
//
//    private boolean finish;
//
//    private String tourType;
//
//    private String city;
//
//    private String region;
//
//    private String country;
//
//    private Member customer;
//
//    private Driver driver;
//
//    @QueryProjection
//    public TourListDto(String tourDate, int personCount, int payment, int takeTime, int visitCount, boolean finish, String tourType, String city, String region, String country, Member customer, Driver driver) {
//        this.tourDate = tourDate;
//        this.personCount = personCount;
//        this.payment = payment;
//        this.takeTime = takeTime;
//        this.visitCount = visitCount;
//        this.finish = finish;
//        this.tourType = tourType;
//        this.city = city;
//        this.region = region;
//        this.country = country;
//        this.customer = customer;
//        this.driver = driver;
//    }
//}
