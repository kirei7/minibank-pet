package com.vlad.learn.repository;

import com.vlad.learn.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByFirstName(String firstName);
    Account getByPhoneNumber(String phoneNumber);
}
