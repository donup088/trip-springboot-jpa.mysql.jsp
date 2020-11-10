package com.trip.tripsoda.domain.tour;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter
@NoArgsConstructor
public class TourAddress {

    private String country;

    private String region;

    private String city;

    public TourAddress(String country, String region, String city) {
        this.country = country;
        this.region = region;
        this.city = city;
    }

}
