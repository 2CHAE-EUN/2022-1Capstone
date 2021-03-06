package com.capstone.controller;

import com.capstone.DTO.AssetDTO;
import com.capstone.DTO.UserDTO;
import com.capstone.DTO.WalletDTO;
import com.capstone.Service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/Login")
    public String loginPage(){
        return "/Login/Login";
    }

    @GetMapping("/FailLogin")
    public String failLogin(Model model){
        model.addAttribute("msg","Login or Password is inVaild");
        return "/Login/Login";
    }

    // 회원가입 폼
    @GetMapping("/SignUpForm")
    public String signUpForm(){
        //사용자가 SignUpForm으로 들어오면 SignUpForm을 반환해준다.
        return "/SignUp/SignUpForm";
    }

    //SignUpForm에서 Post 방식으로 요청이 들어온다면 해당 페이지 반환하기
    //회원가입 진행
    @PostMapping("/SignUpView")
    public String signUp( UserDTO userDTO, AssetDTO assetDTO, WalletDTO walletDTO) {

        userService.joinUser(userDTO,walletDTO,assetDTO);

        System.out.println(userDTO.getNum());
        System.out.println(walletDTO.getNum());
        System.out.println(assetDTO.getNum());

        return "/SignUp/SignUpView";

    }

    @ResponseBody
    @PostMapping("/emailCheck")
    public int emailCheck(@RequestParam("userEmail") String userEmail){
        int emailCheck = userService.emailCheck(userEmail);
        System.out.println(emailCheck);
        return emailCheck;
    }

}


