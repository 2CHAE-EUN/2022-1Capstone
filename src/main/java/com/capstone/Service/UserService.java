package com.capstone.Service;

import com.capstone.DTO.AssetDTO;
import com.capstone.DTO.UserDTO;
import com.capstone.DTO.WalletDTO;
import com.capstone.mapper.UserMapper;
import com.capstone.mapper.WalletMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    WalletMapper walletMapper;

    @Transactional
    public void joinUser(UserDTO userDTO){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userDTO.setUserPassword(passwordEncoder.encode(userDTO.getUserPassword()));
        userDTO.setUserBirth(userDTO.getUserBirYear() + "-" + userDTO.getUserBirMonth() + "-" + userDTO.getUserBirDay() );
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

    public void createWallet(WalletDTO walletDTO){
        walletDTO.setCoinCode("");
        walletDTO.setCoinCount(0);
        walletDTO.setAverageBuyPrice(0);
        walletDTO.setBuyPrice(0);
        walletDTO.setResultPrice(0);
        walletDTO.setResultPL(0);
        walletDTO.setProfitRate(0.0);
        walletMapper.createWallet(walletDTO);
    }


    public void createAsset(AssetDTO assetDTO){
        assetDTO.setUserSeed(10000000);
        assetDTO.setUserTotalSeed(0);
        assetDTO.setUserTotalSeed(0);
        assetDTO.setTotalValuePrice(0);
        assetDTO.setTotalValuePL(0);
        assetDTO.setTotalValueRate(0.0);
        walletMapper.createAsset(assetDTO);
    }

}
