package team20.se61.sut.wongnai.Entity;

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