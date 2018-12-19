package com.sut.se.g20

import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
@Getter @Setter
public class Classification {
    @Id @GeneratedValue
    private Long id;
    public Classification(){}
}