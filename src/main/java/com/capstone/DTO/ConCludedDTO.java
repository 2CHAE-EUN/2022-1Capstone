package com.capstone.DTO;

public class ConCludedDTO {

    private int orderNumber;
    private String orderType;
    private String orderWay;
    private String concludedDate;
    private int orderCount;
    private int ConcludedCount;
    private int orderPrice;
    private int concludedPrice;
    private int concludedTotalPrice;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderWay() {
        return orderWay;
    }

    public void setOrderWay(String orderWay) {
        this.orderWay = orderWay;
    }

    public String getConcludedDate() {
        return concludedDate;
    }

    public void setConcludedDate(String concludedDate) {
        this.concludedDate = concludedDate;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public int getConcludedCount() {
        return ConcludedCount;
    }

    public void setConcludedCount(int concludedCount) {
        ConcludedCount = concludedCount;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getConcludedPrice() {
        return concludedPrice;
    }

    public void setConcludedPrice(int concludedPrice) {
        this.concludedPrice = concludedPrice;
    }

    public int getConcludedTotalPrice() {
        return concludedTotalPrice;
    }

    public void setConcludedTotalPrice(int concludedTotalPrice) {
        this.concludedTotalPrice = concludedTotalPrice;
    }
}
