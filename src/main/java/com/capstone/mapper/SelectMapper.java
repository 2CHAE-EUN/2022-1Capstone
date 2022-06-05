package com.capstone.mapper;

import com.capstone.DTO.AssetDTO;
import com.capstone.DTO.WalletDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SelectMapper {

    //자산 목록 조회
    public List<AssetDTO> getAssetList(int number);

    //지갑 목록 조회
    public List<WalletDTO> getWalletList(int number);

    //시드 조회
    public int validSeed(int number);


}
