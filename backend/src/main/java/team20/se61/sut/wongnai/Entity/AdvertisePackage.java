package team20.se61.sut.wongnai.Entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.*;
@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "AdvertisePackage")
public class AdvertisePackage{
    @Id
    @SequenceGenerator(name="AdvertisePackage_seq",sequenceName="AdvertisePackage_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AdvertisePackage_seq")
    private long id;
    @Column(unique = true)
    private @NotNull String name;
    private @NotNull Double price;
    public AdvertisePackage(String name,Double price){
        this.name = name;
        this.price = price;
    }
}