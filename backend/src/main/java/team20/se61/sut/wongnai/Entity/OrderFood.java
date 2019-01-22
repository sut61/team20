package team20.se61.sut.wongnai.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "OrderFood")
public class OrderFood {
    @Id
    @SequenceGenerator(name="order_seq",sequenceName="order_seq")       
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="order_seq")      
	@Column(name="order_id",unique = true, nullable = true)
    private Long id;
    private @NonNull int CountItem;
    private @NonNull int TotalPrice;

    @ManyToOne()
    @JoinColumn(name= "storeId")
    private Store store;

    @ManyToOne()
    @JoinColumn(name= "foodId")
    private Food food;

    @ManyToOne()
    @JoinColumn(name= "profilesId")
    private ProfilesEntity profile;
    
    public OrderFood(){}
}