package com.vlad.learn.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Card extends IdentifiableEntity {
    private BigDecimal money;

    @NonNull
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "client_id")
    private Account owner;

}
