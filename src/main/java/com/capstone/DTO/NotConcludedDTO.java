package com.capstone.DTO;

public class NotConcludedDTO {

    private int orderNumber;
    private String orderType;
    private String orderWay;
    private int orderCount;
    private int notConcludedCount;
    private int orderPrice;
    private String state;

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

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public int getNotConcludedCount() {
        return notConcludedCount;
    }

    public void setNotConcludedCount(int notConcludedCount) {
        this.notConcludedCount = notConcludedCount;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
