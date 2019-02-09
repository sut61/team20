package team20.se61.sut.wongnai.Entity;

import lombok.*;
import javax.persistence.*;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
@Data

public class PricePerHead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotNull
    private String pricePerHead;

    public PricePerHead(){}

    public PricePerHead(String pricePerHead){
        this.pricePerHead = pricePerHead;
    }
}