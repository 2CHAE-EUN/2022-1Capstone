package com.capstone.DTO;

public class WalletDTO {

    private int num;
    private String coinCode;
    private int coinCount;
    private int averageBuyPrice;
    private int buyPrice;
    private int resultPrice;
    private int resultPL;
    private double profitRate;

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
