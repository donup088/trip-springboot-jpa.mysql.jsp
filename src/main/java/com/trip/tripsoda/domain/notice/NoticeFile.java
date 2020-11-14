package com.trip.tripsoda.domain.notice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString(exclude = {"notice"})
public class NoticeFile {
    @Id
    @Column(name = "trip_photo_uuid", nullable = false)
    private String uuid;

    @Column(name = "uploadPath", nullable = false)
    private String uploadPath;

    @Column(name = "fileName", nullable = false)
    private String fileName;

    private boolean fileType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id")
    @JsonIgnore
    private Notice notice;
}
