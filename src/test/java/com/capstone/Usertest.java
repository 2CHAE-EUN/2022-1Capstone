package com.capstone;

import com.capstone.DTO.UserDTO;

import com.capstone.mapper.UserMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Usertest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert(){

        UserDTO u1 = new UserDTO();
        u1.setUserEmail("2chaechae@gmail.com");
        u1.setUserName("이채채");
        u1.setUserPassword("1234");

        System.out.println(u1);
        userMapper.insertMember(u1);
    }
}