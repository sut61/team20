package sut.se.project.demo.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Data
@Table
public class Recipe {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
                        private Long id;
                        private @NonNull String name;
                        private String  urlPhoto;

    @ManyToOne(fetch = FetchType.LAZY   , cascade = CascadeType.ALL)
    @JoinColumn(name="foodtype") private FoodType foodtype  ;

    @ManyToOne(fetch = FetchType.LAZY   , cascade = CascadeType.ALL)
    @JoinColumn(name="mainingred") private MainIngredients mainingred ;

    @ManyToOne(fetch = FetchType.LAZY   , cascade = CascadeType.ALL)
    @JoinColumn(name="cookingmethod") private CookingMethod cookingmethod;

    public Recipe() {}  

    public Recipe(String name , FoodType foodType , MainIngredients mainIngred, CookingMethod cookingMethod ){

                     
                        this.name = name;
                        this.foodtype = foodType;
                        this.mainingred = mainIngred;
                        this.cookingmethod = cookingMethod;


    }    
                                        



}