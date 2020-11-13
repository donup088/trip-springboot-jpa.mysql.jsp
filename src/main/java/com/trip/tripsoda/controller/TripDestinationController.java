package com.trip.tripsoda.controller;

import com.trip.tripsoda.domain.trip.TripDestination;
import com.trip.tripsoda.domain.trip.TripPhoto;
import com.trip.tripsoda.dto.FileDto;
import com.trip.tripsoda.dto.PageMaker;
import com.trip.tripsoda.dto.trip.TripDestinationRegisterDto;
import com.trip.tripsoda.dto.trip.TripPageDto;
import com.trip.tripsoda.service.TripDestinationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/trip")
@RequiredArgsConstructor
public class TripDestinationController {

    private final TripDestinationService tripDestinationService;

    @GetMapping("/list")
    public void list(@ModelAttribute("pageDto") TripPageDto pageDto, Model model) {
        log.info("trip list~~~~");
        Pageable pageable = pageDto.makePageable();
        //list 넘길 때 dto로 변환해서 tag 안날리면 쿼리 줄어들게 할 수 있음
        Page<TripDestination> tripDestinations = tripDestinationService.getTripDestinationList(
                pageDto.getCountry(), pageDto.getRegion(), pageDto.getCity(), pageDto.getSize(), pageable);

        model.addAttribute("trips", new PageMaker<>(tripDestinations));
    }

    @GetMapping("/register")
    public void register(@ModelAttribute("pageDto") TripPageDto pageDto,
                         @ModelAttribute("trip") TripDestinationRegisterDto tripDestinationRegisterDto) {
        log.info("register...");
        if (tripDestinationRegisterDto.getFileDtos() != null) {
            for (FileDto fileDto : tripDestinationRegisterDto.getFileDtos()) {
                System.out.println(fileDto);
            }
        }
    }

    @GetMapping("/upload")
    public void upload(@ModelAttribute("pageDto") TripPageDto pageDto) {
        log.info("upload get");
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        tripDestinationService.deleteTripDestination(id);

        return "redirect:/trip/list";
    }


    @PostMapping("/register")
    public String registerPost(TripDestinationRegisterDto tripDestinationRegisterDto) {
        log.info("driverDto" + tripDestinationRegisterDto);
        TripDestination tripDestination = dtoToTripDestination(tripDestinationRegisterDto);

        tripDestinationService.register(tripDestination);
        return "redirect:/trip/list";
    }

    private TripDestination dtoToTripDestination(TripDestinationRegisterDto tripDestinationRegisterDto) {

        return TripDestination.builder()
                .country(tripDestinationRegisterDto.getCountry())
                .city(tripDestinationRegisterDto.getCity())
                .code(tripDestinationRegisterDto.getCode())
                .english(tripDestinationRegisterDto.isEnglish())
                .fee(tripDestinationRegisterDto.getFee())
                .korea(tripDestinationRegisterDto.isKorea())
                .tag(tripDestinationRegisterDto.getTags())
                .name(tripDestinationRegisterDto.getName())
                .region(tripDestinationRegisterDto.getRegion())
                .tripPhoto(fileToPhoto(tripDestinationRegisterDto.getFileDtos()))
                .operatingTime(tripDestinationRegisterDto.getOperatingTime())
                .phone(tripDestinationRegisterDto.getPhone())
                .build();
    }

    private List<TripPhoto> fileToPhoto(List<FileDto> fileDtos) {
        List<TripPhoto> tripPhotos=new ArrayList<>();
        for (FileDto fileDto : fileDtos) {
            TripPhoto tripPhoto=new TripPhoto();
            tripPhoto.setUuid(fileDto.getUuid());
            tripPhoto.setFileName(fileDto.getFileName());
            tripPhoto.setFileType(fileDto.isImage());
            tripPhoto.setUploadPath(fileDto.getUploadPath());
            tripPhotos.add(tripPhoto);
        }
        return tripPhotos;
    }
}
