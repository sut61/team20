package team20.se61.sut.wongnai.Entity;

import lombok.*;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
@Data
@ToString
@EqualsAndHashCode
//@NoArgsConstructor
@Table(name="Sex")
public class SexEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long sexid;
    private @NonNull String sex;

    public SexEntity(){}

    public SexEntity(String sex){
        this.sex=sex;
    }

}