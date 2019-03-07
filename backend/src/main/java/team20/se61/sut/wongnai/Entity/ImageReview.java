package team20.se61.sut.wongnai.Entity;

import lombok.*;
import javax.persistence.*;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
@Data

public class ImageReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String image;

    @ManyToOne
    @JsonIgnore
    @NotNull
    private Review reviews;

    public ImageReview(){}

    public ImageReview(String image){
        this.image = image;
    }
}