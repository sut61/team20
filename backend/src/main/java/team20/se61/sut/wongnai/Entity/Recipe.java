package team20.se61.sut.wongnai.Entity;

import lombok.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@SpringBootApplication
@Entity
@Data
@Table
public class Recipe {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
                        private Long id;
                        private @NonNull String name;
                        private String  urlPhoto;
                        private @NonNull String howto;


    @ManyToOne(fetch = FetchType.LAZY   , cascade = CascadeType.ALL)
    @JoinColumn(name="foodtype") private FoodType foodtype  ;

    @ManyToOne(fetch = FetchType.LAZY   , cascade = CascadeType.ALL)
    @JoinColumn(name="mainingred") private MainIngredients mainingred ;

    @ManyToOne(fetch = FetchType.LAZY   , cascade = CascadeType.ALL)
    @JoinColumn(name="cookingmethod") private CookingMethod cookingmethod;

    @ManyToOne(fetch = FetchType.LAZY   , cascade = CascadeType.ALL)
    @JoinColumn(name="profilles") private ProfilesEntity profilles;


    public Recipe() {}  

    public Recipe(String name , FoodType foodType , MainIngredients mainIngred, CookingMethod cookingMethod ,String urlPhoto ,String howto, ProfilesEntity profilles ){

  
                        this.name = name;
                        this.foodtype = foodType;
                        this.mainingred = mainIngred;
                        this.cookingmethod = cookingMethod;
                        this.urlPhoto = urlPhoto;
                        this.howto =howto;
                        this.profilles=profilles;
    }    
                                        



}