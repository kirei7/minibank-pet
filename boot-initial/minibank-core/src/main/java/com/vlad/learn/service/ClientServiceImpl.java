package com.vlad.learn.service;

import com.vlad.learn.model.Client;
import com.vlad.learn.repository.ClientRepository;
import com.vlad.learn.service.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void registerNewClient(ClientDto clientDto) {
        clientRepository.save(clientFromDto(clientDto));
    }

    @Override
    public List<Client> findByFirstName(String firstName) {
        return clientRepository.findByFirstName(firstName);
    }

    private Client clientFromDto(ClientDto clientDto) {
        return new Client(clientDto.getFirstName(), clientDto.getLastName(), clientDto.getPassportId());
    }

}
