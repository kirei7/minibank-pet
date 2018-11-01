package com.vlad.learn.service;

import com.vlad.learn.model.Account;
import com.vlad.learn.service.dto.AccountDto;

import java.util.List;

public interface AccountService {
    Account registerNewAccount(AccountDto accountDto);
    List<Account> findByFirstName(String firstName);
    Account getByPhoneNumber(String firstName);
}
