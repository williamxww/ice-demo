package com.bow.entity;

public class TBOrder {
    private long id;

    private String phone;

    private String orderNum;

    private int orderDate;

    private int ticketType;

    private double amount;

    private int orderStatus;

    public long getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public int getOrderDate() {
        return orderDate;
    }

    public int getTicketType() {
        return ticketType;
    }

    public double getAmount() {
        return amount;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public void setOrderDate(int orderDate) {
        this.orderDate = orderDate;
    }

    public void setTicketType(int ticketType) {
        this.ticketType = ticketType;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
}
