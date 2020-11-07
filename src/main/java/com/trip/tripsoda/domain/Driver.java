package com.trip.tripsoda.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    private Long id;

    private String userid;

    private String address;

    private String region;

    private String name;

    private String birth;

    private String phone;

    private String country;

    private String car;

    private String carNumber;

    private String email;

//    @OneToOne
//    private License license;

    private String department;

    private int driverCount;

    private String complain;

    private int score;

    private String etc;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "driver", cascade = CascadeType.ALL)
    private Profile profile;
}
