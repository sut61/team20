package com.sut.se.g20;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
@Getter @Setter
public class Order {
    @Id @GeneratedValue
    private Long id;
    public Order(){}
}