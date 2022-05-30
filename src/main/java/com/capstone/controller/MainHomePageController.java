package com.capstone.controller;

import com.capstone.DTO.AssetDTO;
import com.capstone.DTO.UserDTO;
import com.capstone.Service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainHomePageController {

    @Autowired
    UserService userService;

    @Autowired
    SqlSession sqlSession;

    @GetMapping("/MainHomePage")
    public String startMainPage(Model model, @AuthenticationPrincipal UserDTO userDTO, AssetDTO assetDTO){

        //사용자가 MainHomePage으로 들어오면 MainHomePage을 반환해준다.

        model.addAttribute("username", userDTO.getUserName());
        model.addAttribute("useremail", userDTO.getUserEmail());
        model.addAttribute("userseed", assetDTO.getUserSeed() );
        System.out.println(assetDTO.getUserSeed());

//        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
//        SelectDTO list = selectMapper.select();
//        model.addAttribute("list", list);

//        AssetDTO assetDTO = selectService.selectAsset();
//        List<UserDTO> list = sqlSession.selectList("assetList.selectAsset");
//        model.addAttribute("list", list);


        return "/Main/MainHomePage";
    }

}
