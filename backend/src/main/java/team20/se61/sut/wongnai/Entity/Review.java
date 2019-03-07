package team20.se61.sut.wongnai.Entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
@Data
@NoArgsConstructor
public class Review {
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Pattern(regexp = "[^0-9].+")
    @Size(min = 3, max = 120)
    @Column(unique=true)
    private String title;

    @NotNull
    @Size(min = 10,max = 120)
    private String detail;

    @ManyToOne
    @NotNull
    private Store store;

    @ManyToOne
    private ProfilesEntity profile;

    @OneToMany(mappedBy = "reviews")
    @NotNull
    private List<ImageReview> imageReview = new ArrayList<>();

    @ManyToOne
    @NotNull
    private PricePerHead pricePerHead;

    @ManyToOne
    @NotNull
    private Rating rating;

}