package com.kickstarter.bank.models;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class CardService {

    private HashMap<String,Card> cards;

    private static CardService instance;

    private CardService() throws ParseException {
        cards = new HashMap<>();
        Card card1 = new Card("Valeriy", "Bondar",
                new SimpleDateFormat("dd/MM/yyyy").parse("20/04/2020"), "1823-4537-2930-4583");
        Card card2 = new Card("Shalya", "Andrew",
                new SimpleDateFormat("dd/MM/yyyy").parse("20/04/2024"), "1812-4127-3531-5000");
        card1.addMoney(100000);
        card2.addMoney(100000);
        cards.put(card1.getNumber(), card1);
        cards.put(card2.getNumber(), card2);
    }

    public boolean checkCard(String number, int donationAmount) {
        Card card = cards.get(number);
        if (card == null)
            return false;
        if (card.getMoney() - donationAmount < 0)
            return false;
        if (card.getDate().before(new Date()))
            return false;
        return true;
    }

    public boolean makeDonation(String number, int donationAmount) {
        if (checkCard(number, donationAmount)) {
            cards.get(number).withdrawMoney(donationAmount);
            return true;
        }
        return false;
    }

    public static CardService getInstance() {
        if (instance == null) {
            try {
                instance = new CardService();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public HashMap<String, Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        this.cards.put(card.getNumber(), card);
    }
}