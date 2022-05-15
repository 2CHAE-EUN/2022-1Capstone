package com.capstone.Service;

import com.capstone.DTO.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface SignUpService {

    public void insertMember(UserDTO userDTO);

}
