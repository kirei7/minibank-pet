package com.vlad.learn.service;

import com.vlad.learn.model.Client;
import com.vlad.learn.service.dto.ClientDto;

import java.util.List;

public interface ClientService {
    void registerNewClient(ClientDto clientDto);
    List<Client> findByFirstName(String firstName);
}
