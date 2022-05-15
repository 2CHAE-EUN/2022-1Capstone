package com.capstone.controller;

import com.capstone.DTO.BankDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserBankController {

    @GetMapping("/MyInvestment")
    public String investPage(Model model){

        // 단일 객체일 경우
        BankDTO bankDTO = new BankDTO( 10000, 99999, 888888 );

        // 여러 개의 객체를 생성
        BankDTO b1 = new BankDTO( 20300, 55555, 81111 );
        BankDTO b2 = new BankDTO( 10220, 44444, 88822 );
        BankDTO b3 = new BankDTO( 9000, 33333, 88833 );
        BankDTO b4 = new BankDTO( 87640, 22222, 884448 );
        BankDTO b5 = new BankDTO( 19000, 11111, 888648 );

        //bList라는 이름으로 BankDTO 객체들을 담는 리스트를 생성한다.
        List<BankDTO> bList = new ArrayList<>();
        bList.add(b1);
        bList.add(b2);
        bList.add(b3);
        bList.add(b4);
        bList.add(b5);

        //model
        model.addAttribute("BankDTO", bankDTO);

        // model 객체를 이용해서 blist도 뷰페이지로 전달을 해줘야한다.
        model.addAttribute("bList", bList);

        return "/Main/MyInvestment";

    }

}
