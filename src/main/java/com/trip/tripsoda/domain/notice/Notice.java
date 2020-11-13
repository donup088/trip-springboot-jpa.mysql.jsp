package com.trip.tripsoda.domain.notice;

import com.trip.tripsoda.domain.Admin;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@ToString(exclude = {"admin","noticeFile"})
@NoArgsConstructor
@AllArgsConstructor
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private Long id;

    private String title;

    private String content;

    private boolean top;

    private boolean secret;

    private int count; //조회수

    private LocalDate createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @OneToMany(mappedBy = "notice")
    private List<NoticeFile> noticeFile = new ArrayList<>();
}
