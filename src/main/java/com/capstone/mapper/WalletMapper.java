package com.capstone.mapper;

import com.capstone.DTO.AssetDTO;
import com.capstone.DTO.WalletDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WalletMapper {

    // 회원가입시 지갑 및 자산 생성
    public void createWallet(WalletDTO walletDTO);
    public void createAsset(AssetDTO assetDTO);

    //자산 초기화
    public void clearAsset(AssetDTO assetDTO);

    ///지갑 초기화
    public void clearWallet(WalletDTO walletDTO);

    // 자산, 지갑 테이블 초기화 후 재생성
    public void recreateWallet(WalletDTO walletDTO);
    public void recreateAsset(AssetDTO assetDTO);

}
