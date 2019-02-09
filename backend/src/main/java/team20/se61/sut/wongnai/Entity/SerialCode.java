package team20.se61.sut.wongnai.Entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.SourceType;

import java.util.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "SerialCode")
public class SerialCode {
    @Id
    @SequenceGenerator(name = "serialCode_seq", sequenceName = "serialCode_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serialCode_seq")
    @Column(name = "serialCode_id", unique = true, nullable = true)
    private long id;

    @NotNull
    @Pattern(regexp = "[A-z|\\d].+")
    @Size(min = 12, max = 12)
    @Column(unique = true)
    private String serialCode;

    @NotNull
    @Size(min = 10, max = 300)
    @Pattern(regexp = "[ก-์|A-z|\\s\\d].+")
    private String detail;

    @NotNull
    private Boolean activate;

    @ManyToOne
    @JoinColumn(name = "storeId")
    private Store store;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conditionId")
    private CodeCondition codeCondition;

}