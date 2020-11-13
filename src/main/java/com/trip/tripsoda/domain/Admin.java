package com.trip.tripsoda.domain;

import com.trip.tripsoda.domain.notice.Notice;
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

    @OneToMany(mappedBy = "admin")
    private List<Notice> notices=new ArrayList<>();
}
