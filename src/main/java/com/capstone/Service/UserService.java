package com.capstone.Service;

import com.capstone.DTO.UserDTO;
import com.capstone.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Transactional
    public void joinUser(UserDTO userDTO){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userDTO.setUserPassword(passwordEncoder.encode(userDTO.getUserPassword()));
        userDTO.setUserAuth("ROLE_USER");
        userMapper.insertMember(userDTO);
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        // 유저 패스워드와 비교하여 로그인 인증
        UserDTO userDTO = userMapper.getUserAccount(userEmail);
        if( userDTO == null ){
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        return userDTO;
    }

}
