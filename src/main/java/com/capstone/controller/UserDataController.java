package com.capstone.controller;

import com.capstone.DTO.AssetDTO;
import com.capstone.DTO.UserDTO;
import com.capstone.DTO.WalletDTO;
import com.capstone.Service.SelectService;
import com.capstone.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserDataController {

    @Autowired
    UserService userService;

    @Autowired
    SelectService selectService;

    @GetMapping("/DeleteMember")
    public String startPage(){
        return "/UserInfo/DeleteMember";
    }

    @GetMapping("/UserData")
    public String loginPage(@AuthenticationPrincipal UserDTO userDTO, AssetDTO assetDTO, WalletDTO walletDTO, Model model){

        walletDTO.setNum(userDTO.getNum());
        assetDTO.setNum(userDTO.getNum());

        model.addAttribute("userName", userDTO.getUserName());
        model.addAttribute("userEmail", userDTO.getUserEmail());
        model.addAttribute("userBirth", userDTO.getUserBirth());
        model.addAttribute("userGender", userDTO.getUserGender());

        List<AssetDTO> assetlist = selectService.getAssetList(assetDTO.getNum());
        model.addAttribute("asset", assetlist);


        return "/UserInfo/UserData";
    }


    @PostMapping("/Delete")
    public String deleteMember(@AuthenticationPrincipal UserDTO userDTO){
        userService.deleteMember(userDTO.getNum());
        return "/UserInfo/DeleteMember";
    }

    @ResponseBody
    @PostMapping("/passwordCheck")
    public boolean emailCheck(@RequestParam("userPassword") String userPassword, @RequestParam("newPassword") String newPassword, @AuthenticationPrincipal UserDTO userDTO ){

        System.out.println(userPassword);
        System.out.println(newPassword);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = userService.selectPassword(userDTO.getNum());
        System.out.println(passwordEncoder.matches(userPassword, password));

        if( passwordEncoder.matches(userPassword, password)) {
            userService.updatePassword(userDTO.getNum(), newPassword);
            return true;
        }else{
            return false;
        }
    }

//    @PostMapping("/clearMyInfo")
//    public String seedClear( @AuthenticationPrincipal UserDTO userDTO, AssetDTO assetDTO, WalletDTO walletDTO, Model model){
//
//
//        return "/UserInfo/UserData";
//    }

}
