package com.capstone.Service;

import com.capstone.DTO.UserDTO;
import com.capstone.mapper.SignUpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceStart implements SignUpService {

    @Autowired
    private SignUpMapper signUpMapper;

    @Override
    public void insertMember(UserDTO userDTO) {
        signUpMapper.insertMember(userDTO);
    }
}
