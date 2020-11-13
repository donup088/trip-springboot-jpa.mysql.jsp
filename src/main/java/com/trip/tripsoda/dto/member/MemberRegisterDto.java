package com.trip.tripsoda.dto.member;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MemberRegisterDto {
    @NotEmpty(message = "아이디를 입력하세요.")
    private String userid;

    @NotEmpty(message = "비밀번호를 입력하세요.")
    private String password;

    @NotEmpty(message = "이름을 입력하세요.")
    private String name;

    @NotEmpty(message = "생년월일을 입력하세요.")
    private String birth;

    @NotEmpty(message = "전화번호를 입력하세요.")
    private String phone;

    @NotEmpty(message = "별명을 입력하세요.")
    private String alias;

    private String email;

    private String address;

    private boolean emailPost;

    private boolean messagePost;

    private String country;

    private String etc;
}
