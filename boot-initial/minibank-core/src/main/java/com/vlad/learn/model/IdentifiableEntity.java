package com.vlad.learn.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter @Setter
abstract class IdentifiableEntity {
    @Id
    @GeneratedValue
    private Long id;
}
