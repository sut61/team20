package team20.se61.sut.wongnai.Entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "CodeCondition")
public class CodeCondition {
    @Id
    @SequenceGenerator(name = "condition_seq", sequenceName = "condition_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "condition_seq")
    @Column(name = "condition_id", unique = true, nullable = true)
    private long id;

    @NotNull
    @Pattern(regexp = "[ก-์|A-z|\\s|\\d].+")
    private String name;

    @NotNull
    @Pattern(regexp = "[ก-์|A-z|\\s|\\d].+")
    private String detail;
}