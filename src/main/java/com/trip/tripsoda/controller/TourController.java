package com.trip.tripsoda.controller;

import com.trip.tripsoda.domain.tour.Tour;
import com.trip.tripsoda.dto.PageMaker;
import com.trip.tripsoda.dto.TourPageDto;
import com.trip.tripsoda.service.TourService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@Slf4j
@RequiredArgsConstructor
public class TourController {

    private final TourService tourService;

    //LocalDate.parse("2018-12-11");   변환가능

    @GetMapping("/tour/list")
    public void list(@ModelAttribute("pageDto") TourPageDto tourPageDto,
                     Model model) {
        log.info("tourPageDto: " + tourPageDto);
        log.info("time: " + tourPageDto.getTourDate());
        String tourDate = formatTourDate(tourPageDto);
        log.info("tourDate: "+tourDate);

        Pageable pageable = tourPageDto.makePageable();

        Page<Tour> tours = tourService.getTourList(
                tourDate,
                tourPageDto.getSize(),
                tourPageDto.getCountry(),
                tourPageDto.getRegion(),
                tourPageDto.getCity(),
                tourPageDto.getDriverName(),
                tourPageDto.getTourType(),
                pageable);

        model.addAttribute("tour", new PageMaker<>(tours));
    }


    //tourDate로 넘어오는 데이터에 있는 ,를 없애고 날짜를 가져옴
    private String formatTourDate(TourPageDto tourPageDto) {
        String tourDate = "";
        if (tourPageDto.getTourDate() != null) {
            String date = tourPageDto.getTourDate();
            String[] split = date.split(",");
            for (String s : split) {
                if (!s.equals("")) {
                    tourDate = s;
                }
            }
        }
        return tourDate;
    }
}
