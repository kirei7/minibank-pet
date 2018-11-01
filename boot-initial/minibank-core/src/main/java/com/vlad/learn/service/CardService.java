package com.vlad.learn.service;

import com.vlad.learn.model.Card;
import com.vlad.learn.model.Account;

public interface CardService {
    Card createCard(Account owner);
    void deleteCard(Card card);
    Card getByCardNumber(String cardNumber);
}
