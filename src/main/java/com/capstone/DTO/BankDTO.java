package com.capstone.DTO;

public class BankDTO {

    private int TotalTradeAmount;
    private int TotalMoney;
    private int MyKRW;

    public BankDTO(){}

    public BankDTO(int totalTradeAmount, int toTalMoney, int myKRW) {
        TotalTradeAmount = totalTradeAmount;
        TotalMoney = toTalMoney;
        MyKRW = myKRW;
    }

    public int getTotalTradeAmount() {
        return TotalTradeAmount;
    }

    public void setTotalTradeAmount(int totalTradeAmount) {
        TotalTradeAmount = totalTradeAmount;
    }

    public int getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        TotalMoney = totalMoney;
    }

    public int getMyKRW() {
        return MyKRW;
    }

    public void setMyKRW(int myKRW) {
        MyKRW = myKRW;
    }
}
