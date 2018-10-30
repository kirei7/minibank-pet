package com.vlad.learn.repository;

import com.vlad.learn.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByFirstName(String firstName);
}
