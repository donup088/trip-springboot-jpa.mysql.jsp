package com.trip.tripsoda.controller;

import com.trip.tripsoda.dto.MemberRegisterDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @PostMapping("/test")
    public String test(MemberRegisterDto memberRegisterDto){
        log.info("memberDto: "+memberRegisterDto);
        return "test";
    }
}
