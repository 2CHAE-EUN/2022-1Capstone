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

    //회원 번호 조회
    public int selectNum();

    //회원 탈퇴하기
    public void deleteMember(int num);

    //비밀 번호 조회하기
    public String selectPassword(int num);

    //비밀 번호 변경하기
    public void updatePassword(int num, String userPassword);

    //자산 초기화
    public void clearAsset(int num);

    ///지갑 초기화
    public void clearWallet(int num);

}
