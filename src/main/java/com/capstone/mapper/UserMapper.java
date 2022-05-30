package com.capstone.mapper;

import com.capstone.DTO.AssetDTO;
import com.capstone.DTO.UserDTO;
import com.capstone.DTO.WalletDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    // 로그인
    UserDTO getUserAccount(String userEmail);

    // 회원가입
    public void insertMember(UserDTO userDTO);

    // 회원가입 중복
    public int emailCheck(String email);


}
