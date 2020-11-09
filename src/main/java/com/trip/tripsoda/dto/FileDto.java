package com.trip.tripsoda.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileDto {
    private String fileName;

    private String uploadPath;

    private String uuid;

    private boolean image;
}
