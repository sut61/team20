package team20.se61.sut.wongnai.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Getter
@Setter
@Table(name = "OrderFood")
public class OrderFood {
    @Id
    @SequenceGenerator(name = "order_seq", sequenceName = "order_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @Column(name = "order_id", unique = true, nullable = true)
    private Long id;

    @Min(1)
    @Max(20)
    private int CountItem;

    @Min(1)
    @Max(1000000)
    private int TotalPrice;

    @NotNull
    @Size(min = 20, max = 300)
    @Pattern(regexp = "[ก-์|A-z|0-9|\\s].+")
    private String DeliverAddress;

    @ManyToOne()
    @JoinColumn(name = "storeId")
    private Store store;

    @ManyToOne()
    @JoinColumn(name = "foodId")
    private Food food;

    @ManyToOne()
    @JoinColumn(name = "profilesId")
    private ProfilesEntity profile;

    public OrderFood() {
    }
}