package com.trip.tripsoda.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    private Long id;

    private String address;

    private String region;

    private String name;

    private String birth;

    private String phone;

    private String car;

    private String carNumber;

//    @OneToOne
//    private License license;

    private int driverCount;

    private String complain;

    private int score;

    private String etc;

    //TODO: 기사 사진, 차량 사진 추가해야함
}
