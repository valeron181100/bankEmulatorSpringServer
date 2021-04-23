package com.kickstarter.bank.models;

import org.json.JSONObject;

import java.math.BigInteger;
import java.util.Date;

public class Card {
    private String firstName;
    private String lastName;
    private Date date;
    private String number;
    private int money;

    public Card(String firstName, String lastName, Date date, String number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.number = number;
        this.money = 0;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int amount) {
        this.money += amount;
    }

    public void withdrawMoney(int amount) {
        this.money -= amount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", getFirstName());
        jsonObject.put("lastName", getLastName());
        jsonObject.put("date", getDate());
        jsonObject.put("number", getNumber());
        jsonObject.put("money", getMoney());
        return jsonObject;
    }
}
