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
public class Percentage {
    @Id
    @SequenceGenerator(name = "Percentage_seq", sequenceName = "Percentage_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Percentage_seq")
    private Long id;
    private @NotNull Long name;

}