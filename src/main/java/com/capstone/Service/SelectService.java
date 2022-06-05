package com.capstone.Service;

import com.capstone.DTO.AssetDTO;
import com.capstone.DTO.UserDTO;
import com.capstone.DTO.WalletDTO;
import com.capstone.mapper.SelectMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectService {

    @Autowired
    private SelectMapper selectMapper;

    @Autowired
    WalletDTO walletDTO;

    @Autowired
    AssetDTO assetDTO;

    public List<WalletDTO> getWalletList(int number){
        List<WalletDTO> walletList = selectMapper.getWalletList(number);
        return walletList;
    }

    public List<AssetDTO> getAssetList(int number){

        List<AssetDTO> assetList = selectMapper.getAssetList(number);

        return assetList;
    }

    public int validSeed(int number){
        int userSeed = selectMapper.validSeed(number);
        return userSeed;
    }


}
