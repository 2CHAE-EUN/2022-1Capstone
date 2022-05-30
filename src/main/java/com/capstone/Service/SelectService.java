package com.capstone.Service;

import com.capstone.DTO.AssetDTO;
import com.capstone.DTO.WalletDTO;
import com.capstone.mapper.SelectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectService {

    @Autowired
    private SelectMapper selectMapper;

    public List<WalletDTO> getWalletList(){
        List<WalletDTO> walletList = selectMapper.getWalletList();
        return walletList;
    }


}
