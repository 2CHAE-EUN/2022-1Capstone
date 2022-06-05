package com.capstone.controller;

import com.capstone.DTO.AssetDTO;
import com.capstone.DTO.UserDTO;
import com.capstone.DTO.WalletDTO;
import com.capstone.Service.SelectService;
import com.capstone.Service.UserService;
import com.capstone.VOs.Order;

import com.capstone.VOs.OrderType;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.util.EnumUtils;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainHomePageController {

    @Autowired
    UserService userService;

    @Autowired
    SelectService selectService;

    @Autowired
    SqlSession sqlSession;

    @GetMapping("/MainHomePage")
    public String startMainPage(Model model, @AuthenticationPrincipal UserDTO userDTO,  AssetDTO assetDTO, WalletDTO walletDTO){

        //사용자가 MainHomePage으로 들어오면 MainHomePage을 반환해준다.

        walletDTO.setNum(userDTO.getNum());
        assetDTO.setNum(userDTO.getNum());

        model.addAttribute("username", userDTO.getUserName());
        model.addAttribute("useremail", userDTO.getUserEmail());

        System.out.println(userDTO.getNum());
        System.out.println(assetDTO.getNum());
        System.out.println(walletDTO.getNum());

        List<AssetDTO> assetlist = selectService.getAssetList(assetDTO.getNum());
        model.addAttribute("asset", assetlist);

        return "/Main/MainHomePage";
    }

    @ResponseBody
    @PostMapping("/market")
    public String tradeAction(@RequestBody Order order, @AuthenticationPrincipal UserDTO userDTO, AssetDTO assetDTO) {
        System.out.println(order);

        assetDTO.setNum(userDTO.getNum());
        int seed = selectService.validSeed(userDTO.getNum()); // 사용자 시드 정보 확인하기

        System.out.println(order.getOrderPrice());
        System.out.println(order.getOrderAmount());
        System.out.println(order.getTotalPrice());

        //검사
        //주문 유형 확인
        if (!(order.getOrderType().name().equals("LIMIT")
                || order.getOrderType().name().equals("MARKET")
                || order.getOrderType().name().equals("STOP_LIMIT"))) {
            //유효하지 않은 타입
            System.out.println("잘못된 주문 유형");
            return "잘못된 주문 유형. 주문 유형은 '', '', '' 중 히니여야 ";
        }

//        //체결 정보 확인
        if (order.getOrderState().name().equals("FILLED")) {
            System.out.println("잘못된 체결 거래입니다.");
            return "잘못된 체결 거래입니다.";
        }

        // 코인 이름 확인
//        if( order.getCoinName() ){
//
//        }

        //최소 거래 금액 확인
        if (seed < 5002.5) {
            System.out.println("최소 주문 금액을 확인해주세요");
            return "최소 주문 금액을 확인해주세요";
        }

        // 지정가일때 입력받는 값
        if (order.getOrderType().name().equals("LIMIT")) {
            //올바른 가격 입력 확인
            if (order.getOrderPrice() <= 1 || order.getOrderAmount() <= 1 || order.getTotalPrice() <= 1) {
                System.out.println("지정가 0보다 큰 수를 입력해주세요");
                return "0보다 큰 수를 입력해주세요";
            }
            // totalPrice = orderPrice * orderAmount 확인
            if (Math.abs(order.getTotalPrice() - order.getOrderPrice() * order.getOrderAmount()) >= 0.0001 ) {
                System.out.println("잘못된 계산처리 입니다.");
                return "잘못된 계산처리 입니다.";
            } else { // 전달받은 값이 제대로 인 경우
                //서비스 처리
            }
        }

            // 시장가일 때 입력받는 값 체크
            if (order.getOrderType().name().equals("MARKET")) {
                if ( order.getTotalPrice() <= 1 ) {
                    System.out.println("시장가 0보다 큰 수를 입력해주세요");
                    return "0보다 큰 수를 입력해주세요";
                }
            }

            // 예약-지정가일 경우 감시 가격 체크
            if (order.getOrderType().name().equals("STOP_LIMIT")) {
                if (order.getOrderWant() <= 1 || order.getOrderPrice() <= 1 || order.getOrderAmount() <= 1 || order.getTotalPrice() <= 1) {
                    System.out.println("예약 지정가 0보다 큰 수를 입력해주세요");
                }
                // totalPrice = orderPrice * orderAmount 확인
                if (Math.abs(order.getTotalPrice() - order.getOrderPrice() * order.getOrderAmount()) >= 0.0001) {
                    System.out.println("잘못된 계산처리 입니다.");
                    return "잘못된 계산처리 입니다.";
                } else { // 전달받은 값이 제대로 인 경우
                    //서비스 처리
                }
            }



            return "it works!";
        }

}

