package team20.se61.sut.wongnai.Entity;

import lombok.*;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
public class Promotion {
    @Id
    @SequenceGenerator(name = "Promotion_seq", sequenceName = "Promotion_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Promotion_seq")
    private Long id;
    @Pattern(regexp = "[ก-์|A-z|\\s].+")
    @Column(unique = true)
    private @NotNull String name;
    @Size(min = 10, max = 100)
    private String detail;

    @ManyToOne()
    @JoinColumn(name = "storeId")
    private Store store;

    @ManyToOne()
    @JoinColumn(name = "promotionTypeId")
    private @NotNull PromotionType promotionType;

    @ManyToOne()
    @JoinColumn(name = "percentageId")
    private @NotNull Percentage percentage;
}