package com.vlad.learn.controller.api;

import com.vlad.learn.model.Client;
import com.vlad.learn.service.ClientService;
import com.vlad.learn.service.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.vlad.learn.controller.api.ClientController.RESOURCE_IDENTIFIER;

@RestController
@RequestMapping(ApiConstants.API_PREFIX + RESOURCE_IDENTIFIER)
public class ClientController {

    static final String RESOURCE_IDENTIFIER = "/clients";

    @Autowired
    private ClientService clientService;

    @PostMapping
    public void registerClient(@RequestBody ClientDto clientDto){
        clientService.registerNewClient(clientDto);
    }

    @GetMapping("/search")
    public List<Client> findByFirstName(@RequestParam("firstName") String firstName) {
        return clientService.findByFirstName(firstName);
    }
}
