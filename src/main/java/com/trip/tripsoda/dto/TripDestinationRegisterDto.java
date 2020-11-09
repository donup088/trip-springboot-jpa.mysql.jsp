package com.trip.tripsoda.dto;

import com.trip.tripsoda.domain.trip.FavoriteTag;
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

    private FavoriteTag favoriteTag;

    private String favorite;

    private String guide;

    private List<FileDto> fileDtos;

    private boolean korea;

    private boolean english;
}
