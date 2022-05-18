package com.capstone.controller;

import com.capstone.DTO.UserDTO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainHomePageController {

    @GetMapping("/MainHomePage")
    public String startMainPage(Model model, @AuthenticationPrincipal UserDTO userDTO){
        //사용자가 MainHomePage으로 들어오면 MainHomePage을 반환해준다.
        model.addAttribute("username", userDTO.getUserName());
        return "/Main/MainHomePage";
    }

}
