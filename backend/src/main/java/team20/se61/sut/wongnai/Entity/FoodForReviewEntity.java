package team20.se61.sut.wongnai.Entity;


import lombok.Data;
import net.bytebuddy.implementation.bind.annotation.Empty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Entity
@Table(name = "FoodForReview")
public class FoodForReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long foodid;

    @NotNull(message = "food name for review not null")
    @Pattern(regexp = "[a-zA-Z]*|[ก-์]*",message = "food name for review not special string")
    private String food;



    @Range(min=0,max=999999999,message = "price Must not Negative")
    private int price;


    @NotNull(message = "food review for review not null")
    private String review;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Restaurant.class,cascade = CascadeType.REMOVE)
    @JoinColumn(name="restaurantid",insertable = true)
    @NotNull(message = "food restaurant not null")
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = ProfilesEntity.class,cascade = CascadeType.REMOVE)
    @JoinColumn(name="profilesid",insertable = true)
    @NotNull(message = " User review not null")
    private ProfilesEntity  profilesEntity;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = PointFoodEntity.class,cascade = CascadeType.REMOVE)
    @JoinColumn(name="pointfoodid",insertable = true)
    @NotNull(message = "point not null")
    private PointFoodEntity pointFood;

}
