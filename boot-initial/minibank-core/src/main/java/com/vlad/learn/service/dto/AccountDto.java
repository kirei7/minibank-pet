package com.vlad.learn.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
