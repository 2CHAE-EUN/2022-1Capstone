package com.capstone.mapper;

import com.capstone.DTO.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    // 로그인
    UserDTO getUserAccount(String userEmail);

    // 회원가입
    public void insertMember(UserDTO userDTO);

}
