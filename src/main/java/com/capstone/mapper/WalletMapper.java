package com.capstone.mapper;

import com.capstone.DTO.AssetDTO;
import com.capstone.DTO.WalletDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WalletMapper {

    // 회원가입시 지갑 및 자산 생성
    public void createWallet(WalletDTO walletDTO);
    public void createAsset(AssetDTO assetDTO);

}
