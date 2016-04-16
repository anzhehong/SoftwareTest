package com.calculator;

/**
 * Created by fowafolo
 * Date: 16/4/16
 * Time: 15:59
 */
public class Bill {

    private double minute;
    private double historyAmount;
    private int totalNotPaid;
    private double discountRate;
    private double actualAmount;
    private String payWay;


    public Bill(double minute, double historyAmount, int totalNotPaid) {
        this.minute = minute;
        this.historyAmount = historyAmount;
        this.totalNotPaid = totalNotPaid;
        this.discountRate = 0;
        this.actualAmount = 0;
        this.payWay = "";
    }

    public double getMinute() {
        return minute;
    }

    public void setMinute(double minute) {
        this.minute = minute;
    }

    public double getHistoryAmount() {
        return historyAmount;
    }

    public void setHistoryAmount(double historyAmount) {
        this.historyAmount = historyAmount;
    }

    public int getTotalNotPaid() {
        return totalNotPaid;
    }

    public void setTotalNotPaid(int totalNotPaid) {
        this.totalNotPaid = totalNotPaid;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(double actualAmount) {
        this.actualAmount = actualAmount;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }
}
