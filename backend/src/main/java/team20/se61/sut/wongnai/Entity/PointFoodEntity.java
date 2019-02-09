package team20.se61.sut.wongnai.Entity;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import javax.persistence.*;

@Data
@Entity
@Table(name ="pointfood")
public class PointFoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pointfoodid;

    @Range(min = 0,max=5,message = "pointfood 0-5 only")
    @Column(unique = true)
    private int pointfood;

    public PointFoodEntity(){}

    public PointFoodEntity(int pointfood){
        this.pointfood=pointfood;
    }
}
