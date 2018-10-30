package com.vlad.learn.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client extends IdentifiableEntity{
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    @Column(unique = true, nullable = false)
    private String passportId;
}
