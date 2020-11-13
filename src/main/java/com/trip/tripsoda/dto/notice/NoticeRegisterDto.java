package com.trip.tripsoda.dto.notice;

import com.trip.tripsoda.domain.Admin;
import com.trip.tripsoda.domain.notice.NoticeFile;
import com.trip.tripsoda.dto.FileDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class NoticeRegisterDto {
    private String title;

    private String content;

    private boolean top;

    private boolean secret;

    private int count;

    private NoticeRegisterAdminDto adminDto;

    private List<FileDto> fileDtos;
}
