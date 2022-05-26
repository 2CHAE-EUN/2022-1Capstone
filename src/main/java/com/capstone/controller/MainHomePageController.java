package com.capstone.controller;

import com.capstone.DTO.AssetDTO;
import com.capstone.DTO.UserDTO;
import com.capstone.DTO.WalletDTO;
import com.capstone.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainHomePageController {

    @Autowired
    UserService userService;

    @GetMapping("/MainHomePage")
    public String startMainPage(Model model, @AuthenticationPrincipal UserDTO userDTO){

        //사용자가 MainHomePage으로 들어오면 MainHomePage을 반환해준다.

        model.addAttribute("username", userDTO.getUserName());
        model.addAttribute("userEmail", userDTO.getUserEmail());

        return "/Main/MainHomePage";
    }

}
