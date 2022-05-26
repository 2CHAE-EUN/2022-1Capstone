package com.capstone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InvestmentController {

    @GetMapping("/Investment")
    public String checkMyInvestment(){
        return "/Investment/Investment";
    }

}
