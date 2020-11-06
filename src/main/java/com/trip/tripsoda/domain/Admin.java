package com.trip.tripsoda.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long id;

    private String userid;

    private String password;

    private String name;

    private String birth;

    private String phone;

    private String email;

    private String englishName;

    private String address;

    private String country;

    private String joinDate;

    private String job;

    private String department;

    private String etc;
}
