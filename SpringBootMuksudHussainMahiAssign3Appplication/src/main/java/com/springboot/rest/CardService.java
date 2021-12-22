package com.springboot.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CardService {
	Map<Integer, Card> cards = new HashMap<>();

    public void addCard(Card card) throws Exception {
        if(cards.containsKey(card.getCardNo())) {
            throw new Exception("This card already exists");
        }
        else {
            cards.put(card.getCardNo(), card);
        }
    }

    public Iterable<Card> getCards(){
        return cards.values();
    }

    public Card getCard(int cardNo) throws Exception {

        if(cards.containsKey(cardNo)) {
            return cards.get(cardNo);
        }
        else {
            throw new Exception("Card not found");
        }
    }

    public void updateCard(Card card) throws Exception {
        if(cards.containsKey(card.getCardNo())) {
            cards.put(card.getCardNo(), card);
        }
        else {
            throw new Exception("Card Id not found");
        }
    }

    public void deleteCard(int cardNo) throws Exception {
        if(cards.containsKey(cardNo)) {
            cards.remove(cardNo);
        }
        else {
            throw new Exception("Card not found");
        }
    }
}
