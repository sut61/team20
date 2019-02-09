package team20.se61.sut.wongnai.Entity;

import lombok.*;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;

@Entity
@Data

public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String rating;

    public Rating(){}

    public Rating(String rating){
        this.rating = rating;
    }
}