package com.capstone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainHomePageController {

    @GetMapping("/MainHomePage")
    public String startMainPage(){
        //사용자가 MainHomePage으로 들어오면 MainHomePage을 반환해준다.
        return "/Main/MainHomePage";
    }

}
