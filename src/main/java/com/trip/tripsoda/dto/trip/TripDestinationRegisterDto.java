package com.trip.tripsoda.dto.trip;

import com.trip.tripsoda.domain.trip.FavoriteTag;
import com.trip.tripsoda.dto.FileDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripDestinationRegisterDto {

    private String country;

    private String city;

    private String region;

    private String code;

    private String name;

    private String phone;

    private int fee;

    private String operatingTime;

    private String guide;

    private List<FileDto> fileDtos;

    private FavoriteTag tags;

    private boolean korea;

    private boolean english;
}
