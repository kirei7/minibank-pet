package com.vlad.learn.service;

import com.vlad.learn.model.Account;
import com.vlad.learn.repository.AccountRepository;
import com.vlad.learn.service.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account registerNewAccount(AccountDto accountDto) {
        return accountRepository.save(accountFromDto(accountDto));
    }

    @Override
    public List<Account> findByFirstName(String firstName) {
        return accountRepository.findByFirstName(firstName);
    }

    @Override
    public Account getByPhoneNumber(String phoneNumber) {
        return accountRepository.getByPhoneNumber(phoneNumber);
    }

    private Account accountFromDto(AccountDto accountDto) {
        return new Account(accountDto.getFirstName(), accountDto.getLastName(), accountDto.getPhoneNumber());
    }

}
