package com.capstone.controller;

import com.capstone.DTO.UserDTO;
import com.capstone.Service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/SignUpForm")
    public String insertMember(){
    //사용자가 SignUpForm으로 들어오면 SignUpForm을 반환해준다.
        return "/SignUp/SignUpForm";
    }

    //SignUpForm에서 Post 방식으로 요청이 들어온다면 해당 페이지 반환하기
    @PostMapping("/SignUpView")
    public String insertMember( UserDTO userDTO){
            signUpService.insertMember(userDTO);
            return "/SignUp/SignUpView";
    }

}



