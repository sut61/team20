package team20.se61.sut.wongnai.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter @Setter
public class Restaurant {
    @Id
    @SequenceGenerator(name="res_seq",sequenceName="res_seq")       
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="res_seq")      
	@Column(name="restaurant_id",unique = true, nullable = true)
    private @NonNull Long id;
    @NonNull
    private String Name;
    @NonNull
    private String Address;

    public Restaurant(){}
}