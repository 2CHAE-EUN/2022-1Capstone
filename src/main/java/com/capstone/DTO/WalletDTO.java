package com.capstone.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class WalletDTO {

    private int num;
    private String coinCode;
    private int coinCount;
    private int averageBuyPrice;
    private int buyPrice;
    private int resultPrice;
    private int resultPL;
    private double profitRate;

    public WalletDTO(){}

    public WalletDTO(int num, String coinCode, int coinCount, int averageBuyPrice, int buyPrice, int resultPrice, int resultPL, double profitRate) {
        this.num = num;
        this.coinCode = coinCode;
        this.coinCount = coinCount;
        this.averageBuyPrice = averageBuyPrice;
        this.buyPrice = buyPrice;
        this.resultPrice = resultPrice;
        this.resultPL = resultPL;
        this.profitRate = profitRate;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCoinCode() {
        return coinCode;
    }

    public void setCoinCode(String coinCode) {
        this.coinCode = coinCode;
    }

    public int getCoinCount() {
        return coinCount;
    }

    public void setCoinCount(int coinCount) {
        this.coinCount = coinCount;
    }

    public int getAverageBuyPrice() {
        return averageBuyPrice;
    }

    public void setAverageBuyPrice(int averageBuyPrice) {
        this.averageBuyPrice = averageBuyPrice;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getResultPrice() {
        return resultPrice;
    }

    public void setResultPrice(int resultPrice) {
        this.resultPrice = resultPrice;
    }

    public int getResultPL() {
        return resultPL;
    }

    public void setResultPL(int resultPL) {
        this.resultPL = resultPL;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }
}
