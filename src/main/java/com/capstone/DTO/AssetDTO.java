package com.capstone.DTO;


import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Data
@Component
public class AssetDTO {

    private int num;
    private int userSeed;
    private int userTotalSeed;
    private int totalBuyPrice;
    private int totalValuePrice;
    private int totalValuePL;
    private double totalValueRate;

    public AssetDTO(){}

    public AssetDTO(int num, int userSeed, int userTotalSeed, int totalBuyPrice, int totalValuePrice, int totalValuePL, double totalValueRate) {
        this.num = num;
        this.userSeed = userSeed;
        this.userTotalSeed = userTotalSeed;
        this.totalBuyPrice = totalBuyPrice;
        this.totalValuePrice = totalValuePrice;
        this.totalValuePL = totalValuePL;
        this.totalValueRate = totalValueRate;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getUserSeed() {
        return userSeed;
    }

    public void setUserSeed(int userSeed) {
        this.userSeed = userSeed;
    }

    public int getUserTotalSeed() {
        return userTotalSeed;
    }

    public void setUserTotalSeed(int userTotalSeed) {
        this.userTotalSeed = userTotalSeed;
    }

    public int getTotalBuyPrice() {
        return totalBuyPrice;
    }

    public void setTotalBuyPrice(int totalBuyPrice) {
        this.totalBuyPrice = totalBuyPrice;
    }

    public int getTotalValuePrice() {
        return totalValuePrice;
    }

    public void setTotalValuePrice(int totalValuePrice) {
        this.totalValuePrice = totalValuePrice;
    }

    public int getTotalValuePL() {
        return totalValuePL;
    }

    public void setTotalValuePL(int totalValuePL) {
        this.totalValuePL = totalValuePL;
    }

    public double getTotalValueRate() {
        return totalValueRate;
    }

    public void setTotalValueRate(double totalValueRate) {
        this.totalValueRate = totalValueRate;
    }
}
