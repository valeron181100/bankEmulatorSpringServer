package com.kickstarter.bank.models;

public class CardHttpRequestBody {
    private String number;
    private int money;

    public CardHttpRequestBody(String number, int money) {
        this.number = number;
        this.money = money;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
