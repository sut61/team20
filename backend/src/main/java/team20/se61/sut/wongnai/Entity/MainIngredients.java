package sut.se.project.demo.entity;

import lombok.*;
import javax.persistence.*;


@Entity
@Data
@Table
public class MainIngredients {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
                        private Long id;
                        private @NonNull String name;
                       

    protected MainIngredients(){}

    public MainIngredients( String name){

                       
                        this.name = name;

    }    
}