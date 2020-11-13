package com.trip.tripsoda.controller;

import com.trip.tripsoda.domain.Member;
import com.trip.tripsoda.domain.dirver.Driver;
import com.trip.tripsoda.domain.tour.Tour;
import com.trip.tripsoda.domain.tour.TourAddress;
import com.trip.tripsoda.dto.PageMaker;
import com.trip.tripsoda.dto.tour.TourPageDto;
import com.trip.tripsoda.dto.tour.TourRegisterDto;
import com.trip.tripsoda.service.DriverService;
import com.trip.tripsoda.service.MemberService;
import com.trip.tripsoda.service.TourService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import static java.lang.Integer.parseInt;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/tour")
public class TourController {

    private final TourService tourService;
    private final DriverService driverService;
    private final MemberService memberService;

    //LocalDate.parse("2018-12-11");   변환가능

    @GetMapping("/list")
    public void list(@ModelAttribute("pageDto") TourPageDto tourPageDto,
                     Model model) {
        log.info("tourPageDto: " + tourPageDto);
        log.info("time: " + tourPageDto.getTourDate());
        String tourDate = formatTourDate(tourPageDto.getTourDate());
        log.info("tourDate: " + tourDate);

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

    @GetMapping("/register")
    public void register(@ModelAttribute("pageDto") TourPageDto pageDto,
                         @ModelAttribute("tour") TourRegisterDto tourRegisterDto) {
        log.info("tour register...");
    }

    @PostMapping("/register")
    public String register(TourRegisterDto tourRegisterDto) {
        log.info("tourRegisterDto: " + tourRegisterDto);
        Tour tour = dtoToTour(tourRegisterDto);

        tourService.register(tour);
        return "redirect:/tour/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        tourService.deleteTour(id);

        return "redirect:/tour/list";
    }

    //멤버 찾으면서 구매 횟수 늘리고, 기사 찾으면서 운행횟수 늘리도록 함
    private Tour dtoToTour(TourRegisterDto tourRegisterDto) {
        Member member = memberService.findMemberToBuyTour(tourRegisterDto.getMember().getName());
        Driver driver = driverService.findDriverToBuyTour(tourRegisterDto.getDriver().getDriverName());
        LocalDate tourDate = StringToLocalDate(tourRegisterDto.getTourDate());

        return Tour.builder()
                .address(new TourAddress(tourRegisterDto.getCountry(), tourRegisterDto.getRegion(), tourRegisterDto.getCity()))
                .customer(member)
                .driver(driver)
                .tourDate(tourDate)
                .payment(tourRegisterDto.getPayment())
                .personCount(tourRegisterDto.getPersonCount())
                .name(tourRegisterDto.getName())
                .takeTime(tourRegisterDto.getTakeTime())
                .startTime(tourRegisterDto.getStartTime())
                .buyType(tourRegisterDto.getBuyType())
                .code(tourRegisterDto.getCode())
                .buyPay(tourRegisterDto.getBuyPay())
                .tourType(tourRegisterDto.getTourType())
                .visitCount(tourRegisterDto.getVisitCount())
                .finish(false)
                .build();
    }


    private LocalDate StringToLocalDate(String date) {
        String[] split = date.split("-");
        return LocalDate.of(parseInt(split[0]), parseInt(split[1]), parseInt(split[2]));
    }

    //tourDate로 넘어오는 데이터에 있는 ,를 없애고 날짜를 가져옴
    private String formatTourDate(String tourDate) {
        if (tourDate != null) {
            String[] split = tourDate.split(",");
            for (String s : split) {
                if (!s.equals("")) {
                    tourDate = s;
                }
            }
        }
        return tourDate;
    }
}
