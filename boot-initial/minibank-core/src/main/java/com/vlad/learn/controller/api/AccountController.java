package com.vlad.learn.controller.api;

import com.vlad.learn.model.Card;
import com.vlad.learn.model.Account;
import com.vlad.learn.service.CardService;
import com.vlad.learn.service.AccountService;
import com.vlad.learn.service.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.vlad.learn.controller.api.AccountController.RESOURCE_MAPPING;

@RestController
@RequestMapping(RESOURCE_MAPPING)
public class AccountController {

    static final String RESOURCE_MAPPING = ApiConstants.API_PREFIX + "/accounts";

    @Autowired
    private AccountService accountService;
    @Autowired
    private CardService cardService;

    @PostMapping
    public AccountDto registerClient(@RequestBody AccountDto accountDto){
        Account registered = accountService.registerNewAccount(accountDto);
        return AccountDto.builder()
                .firstName(registered.getFirstName())
                .lastName(registered.getLastName())
                .build();
    }

    @GetMapping("/search")
    public List<Account> findByFirstName(@RequestParam("firstName") String firstName) {
        return accountService.findByFirstName(firstName);
    }

    @RestController
    @RequestMapping(RESOURCE_MAPPING + "/{clientPhoneNumber}/cards")
    public class AccountCardController {

        @GetMapping
        public List<Card> getCards(@PathVariable String clientPhoneNumber) {
            Account account = accountService.getByPhoneNumber(clientPhoneNumber);
            return account.getCards();
        }

        @GetMapping("/{cardNumber}")
        public Card getCardByNumber(@PathVariable String cardNumber) {
            return cardService.getByCardNumber(cardNumber);
        }

        @PostMapping
        public Card createNewAccount(@PathVariable String clientPhoneNumber) {
            Account account = accountService.getByPhoneNumber(clientPhoneNumber);
            return cardService.createCard(account);
        }
    }
}
