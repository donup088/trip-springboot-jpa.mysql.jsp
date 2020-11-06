package com.trip.tripsoda.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"orders","questions"})
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String userid;

    private String password;

    private String name;

    private String birth;

    private String email;

    private String phone;

    private String alias;

    private String address;

    private boolean emailPost;

    private boolean messagePost;

    private String country;

    private String etc;

    @OneToMany(mappedBy = "member")
    private List<Order> orders=new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Question> questions=new ArrayList<>();
}
