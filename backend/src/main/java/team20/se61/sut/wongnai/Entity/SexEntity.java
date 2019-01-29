package team20.se61.sut.wongnai.Entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Data
@Table(name="Sex")
public class SexEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long sexid;

    private
    @NotNull(message = "กรุณาเลือกเพศ")
    @Column(unique = true)
    @Pattern(regexp = "หญิง|ชาย",message ="หญิง หรือ ชาย เท่านั้น" )
    String sex;


    public SexEntity(){}

    public SexEntity(String sex){
        this.sex=sex;

    }

}