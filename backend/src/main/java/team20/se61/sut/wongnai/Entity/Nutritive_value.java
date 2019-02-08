package team20.se61.sut.wongnai.Entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;



@Entity
@Data
@Table
public class Nutritive_value {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotNull()@Min(0)@Max(2000)private float energy;

    @NotNull()@Min(0)@Max(70)private float sugar;

    @NotNull()@Min(0)@Max(90)private float fat;

    @NotNull()@Min(0)@Max(3000)private float sodium;

    @NotNull()@Min(0)@Max(20)private float saturates;

    @NotNull()@Min(1)@Max(500)private float amount;


   
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "Recipe_id", unique = true)
    private  @NotNull Recipe recipe;


}