package sut.se.project.demo.entity;

import lombok.*;
import javax.persistence.*;


@Entity
@Data
@Table
public class FoodType {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
                        private Long id;
                        private @NonNull String name;
                       
    protected FoodType(){}

    public FoodType(String name){

                      
                        this.name =name;
    }

}