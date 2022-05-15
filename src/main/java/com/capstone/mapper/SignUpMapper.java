package com.capstone.mapper;

import com.capstone.DTO.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SignUpMapper {

    public void insertMember(UserDTO userDTO);
}
