package com.capstone.VOs;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@JsonAutoDetect
@ToString
public class Order {

    private OrderType orderType;
    private Boolean isBuying;
    private OrderState orderState;
    private String coinName;
    private Double orderWant; // 감시가격
    private Double orderPrice;
    private Double orderAmount;
    private Double totalPrice;

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public Boolean getBuying() {
        return isBuying;
    }

    public void setBuying(Boolean buying) {
        isBuying = buying;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public Double getOrderWant() {
        return orderWant;
    }

    public void setOrderWant(Double orderWant) {
        this.orderWant = orderWant;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
