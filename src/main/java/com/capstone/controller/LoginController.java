package com.capstone.controller;

import com.capstone.DTO.LoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {


    @GetMapping("/Login")
    public String loginPage(){
        return "/Login/Login";
    }

    @PostMapping("/MainHomePage")
    public String loginComplete(LoginDTO loginDTO){
        return "/Main/MainHomePage";
    }


}


