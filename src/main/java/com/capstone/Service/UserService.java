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


@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    WalletMapper walletMapper;


    @Transactional
    public void joinUser(UserDTO userDTO, WalletDTO walletDTO, AssetDTO assetDTO){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userDTO.setUserPassword(passwordEncoder.encode(userDTO.getUserPassword()));
        userDTO.setUserBirth(userDTO.getUserBirYear() + "-" + userDTO.getUserBirMonth() + "-" + userDTO.getUserBirDay() );
        userDTO.setUserAuth("ROLE_USER");

        userMapper.insertMember(userDTO);

        walletDTO.setNum(userDTO.getNum());
        assetDTO.setNum(userDTO.getNum());

        createAsset(assetDTO);
        createWallet(walletDTO);
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        // 유저 패스워드와 비교하여 로그인 인증
        UserDTO userDTO = userMapper.getUserAccount(userEmail);
        System.out.println(userDTO);
        if( userDTO == null ){
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        return userDTO;
    }

    public void createWallet(WalletDTO walletDTO){
        walletDTO.setCoinCode("11");
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

    public int emailCheck(String email){
        int check = userMapper.emailCheck(email);
        return check;
    }

    public void deleteMember(int num){
        userMapper.deleteMember(num);
    }

    public String selectPassword(int num){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String password = userMapper.selectPassword(num);

        return password;

    }

    public void updatePassword( int num, String userPassword){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userMapper.updatePassword(num, passwordEncoder.encode(userPassword));
    }

    public void clearAsset(AssetDTO assetDTO){

        walletMapper.clearAsset(assetDTO);

        assetDTO.setUserSeed(1000);
        assetDTO.setUserTotalSeed(0);
        assetDTO.setUserTotalSeed(0);
        assetDTO.setTotalValuePrice(0);
        assetDTO.setTotalValuePL(0);
        assetDTO.setTotalValueRate(0.0);

        walletMapper.recreateAsset(assetDTO);

    }

    public void clearWallet(WalletDTO walletDTO){

        walletMapper.clearWallet(walletDTO);

        walletDTO.setCoinCode("초기화 성공");
        walletDTO.setCoinCount(0);
        walletDTO.setAverageBuyPrice(0);
        walletDTO.setBuyPrice(0);
        walletDTO.setResultPrice(0);
        walletDTO.setResultPL(0);
        walletDTO.setProfitRate(0.0);

        walletMapper.recreateWallet(walletDTO);
    }

}
