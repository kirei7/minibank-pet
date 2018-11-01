package com.vlad.learn.service;

import com.vlad.learn.model.Card;
import com.vlad.learn.model.Account;
import com.vlad.learn.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private AccountService accountService;

    @Override
    public Card createCard(Account owner) {
        Card card = new Card(owner);
        card.setMoney(BigDecimal.ZERO);
        return cardRepository.save(card);
    }

    @Override
    public void deleteCard(Card card) {

    }

    @Override
    public Card getByCardNumber(String cardNumber) {
        //TODO: make it search by card number, not by id
        return cardRepository.findById(Long.parseLong(cardNumber)).get();
    }

    private Account getClient(Account account) {
        return null;
    }
}
