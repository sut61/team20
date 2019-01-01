package team20.se61.sut.wongnai.Entity;

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