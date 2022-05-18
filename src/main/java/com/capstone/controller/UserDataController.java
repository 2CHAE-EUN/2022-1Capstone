package com.capstone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserDataController {

    @GetMapping("/UserData")
    public String checkMyInform(){
        //사용자가 MainHomePage으로 들어오면 MainHomePage을 반환해준다.
        return "/UserInfo/UserData";
    }

}
