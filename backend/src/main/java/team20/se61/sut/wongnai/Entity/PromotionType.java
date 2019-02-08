package team20.se61.sut.wongnai.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class PromotionType {
    @Id
    @SequenceGenerator(name = "PromotionType_seq", sequenceName = "PromotionType_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PromotionType_seq")
    private Long id;
    private @NotNull String name;

}