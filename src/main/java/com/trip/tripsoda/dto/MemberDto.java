package com.trip.tripsoda.dto;

import lombok.Data;

@Data
public class MemberDto {
    private Long id;

    private String userid;

    private String name;

    private String phone;

    private String email;

    private String country;

    private Long orderCount;

    private Long questionCount;
}
