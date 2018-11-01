package com.vlad.learn.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Account extends IdentifiableEntity{
    @NonNull
    @Column(nullable = false)
    @EqualsAndHashCode.Exclude
    private String firstName;

    @NonNull
    @Column(nullable = false)
    @EqualsAndHashCode.Exclude
    private String lastName;

    @NonNull
    @EqualsAndHashCode.Include
    @Column(unique = true, nullable = false)
    private String phoneNumber;

    @JsonBackReference
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "owner")
    private List<Card> cards;
}
