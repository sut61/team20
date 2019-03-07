package team20.se61.sut.wongnai.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Getter
@Setter
@Table(name = "Food")
public class Food {
    @Id
    @SequenceGenerator(name = "food_seq", sequenceName = "food_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "food_seq")
    @Column(name = "food_id", unique = true, nullable = true)
    private Long id;

    @NotNull
    @Pattern(regexp = "[ก-์|A-z|\\s].+")
    private String Name;

    @Max(10000)
    @Min(1)
    private int Price;

    @NotNull
    @Pattern(regexp = "(http(s?):).+(.jpg|.gif|.png).*", message = "imgUrl is not Pattern")
    private String Image;

    @ManyToOne()
    @JoinColumn(name = "storeId")
    private Store store;

    public Food() {
    }
}