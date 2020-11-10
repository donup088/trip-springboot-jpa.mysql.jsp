package com.trip.tripsoda.dto;

import com.trip.tripsoda.domain.dirver.Driver;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

@Data
public class TourPageDto {
    private static final int DEFAULT_MIN_SIZE = 1;
    private static final int DEFAULT_SIZE = 10;
    private static final int DEFAULT_MAX_SIZE = 50;

    private int page;
    private int size;

    private String country;
    private String region;
    private String city;
    private LocalDateTime tourDate;
    private String tourType;
    private Driver driver;

    public TourPageDto() {
        this.page = 1;
        this.size = DEFAULT_SIZE;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page < 0 ? 1 : page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size < DEFAULT_MIN_SIZE || size > DEFAULT_MAX_SIZE ? DEFAULT_SIZE : size;
    }

    public Pageable makePageable() {
        return PageRequest.of(this.page - 1, this.size);
    }
}
