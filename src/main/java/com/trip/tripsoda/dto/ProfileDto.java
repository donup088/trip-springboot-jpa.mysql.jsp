package com.trip.tripsoda.dto;

import lombok.Data;

@Data
public class ProfileDto {
    private String fileName;

    private String uploadPath;

    private String uuid;

    private boolean image;
}
