package team20.se61.sut.wongnai.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Order {
    @Id
    @SequenceGenerator(name="order_seq",sequenceName="order_seq")       
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="order_seq")      
	@Column(name="order_id",unique = true, nullable = true)
    private Long id;
    private int CountItem;
    private Long TotalPrice;

    // Order --> User
//    @ManyToOne()   
//    @JoinColumn(name= "user_id")     
//    private User user;

    // Order --> Restaurant
    @ManyToOne()   
    @JoinColumn(name= "restaurant_id")     
    private Restaurant restaurant;   

    public Order(){}
}