package sut.se.project.demo.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Data
@Table
public class CookingMethod {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
                        private Long id;
                        private @NonNull String name;

    protected CookingMethod(){}

    public CookingMethod(String name){
                    
                  
                        this.name =name;
    }                       

}