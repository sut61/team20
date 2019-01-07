package team20.se61.sut.wongnai.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Food {
    @Id
    @SequenceGenerator(name="food_seq",sequenceName="food_seq")       
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="food_seq")      
	@Column(name="food_id",unique = true, nullable = true)
    private @NonNull Long id;
    private @NonNull String Name;
    private @NonNull int Price;

    // Food --> Restaurant
    @ManyToOne()   
    @JoinColumn(name= "restaurant_id")     
    private Restaurant restaurant;

    public Food(){}
}