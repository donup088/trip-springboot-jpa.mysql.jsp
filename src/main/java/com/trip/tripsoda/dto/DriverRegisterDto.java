package com.trip.tripsoda.dto;

import com.trip.tripsoda.domain.dirver.Profile;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class DriverRegisterDto {
    @NotEmpty(message = "아이디를 입력하세요.")
    private String userid;

    @NotEmpty(message = "주소를 입력하세요.")
    private String address;

    @NotEmpty(message = "지역을 입력하세요.")
    private String region;

    @NotEmpty(message = "이름을 입력하세요.")
    private String name;

    @NotEmpty(message = "생년월일을 입력하세요.")
    private String birth;

    @NotEmpty(message = "전화번호를 입력하세요.")
    private String phone;

    private Profile profile;

    private String country;

    private String car;

    private String carNumber;

    private String email;

    private String department;

    private int driverCount;

    private String complain;

    private int score;

    private String etc;

}
