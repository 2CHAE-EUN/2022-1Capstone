package com.capstone.controller;

import com.capstone.DTO.AssetDTO;
import com.capstone.DTO.UserDTO;
import com.capstone.DTO.WalletDTO;
import com.capstone.Service.SelectService;
import com.capstone.Service.UserService;
import com.capstone.mapper.SelectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class InvestmentController {

    @Autowired
    UserDTO userDTO;

    @Autowired
    WalletDTO walletDTO;

    @Autowired
    SelectService selectService;

    @Autowired
    UserService userService;

    @GetMapping("/Investment")
    public String checkMyInvestment(Model model, @AuthenticationPrincipal UserDTO userDTO, WalletDTO walletDTO, AssetDTO assetDTO){

        walletDTO.setNum(userDTO.getNum());
        assetDTO.setNum(userDTO.getNum());

        List<WalletDTO> walletlist = selectService.getWalletList(walletDTO.getNum());
        List<AssetDTO> assetlist = selectService.getAssetList(assetDTO.getNum());

        model.addAttribute("wallet", walletlist);
        model.addAttribute("asset", assetlist);

        List<AssetDTO> myasset = selectService.getAssetList(assetDTO.getNum());
        model.addAttribute("asset", myasset);

        return "/Investment/Investment";
    }

}
