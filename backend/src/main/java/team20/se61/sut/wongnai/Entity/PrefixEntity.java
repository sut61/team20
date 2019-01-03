package team20.se61.sut.wongnai.Entity;

import lombok.*;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
@Data
@ToString
@EqualsAndHashCode
//@NoArgsConstructor
@Table(name="Prefix")
public class PrefixEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long prefixid;
    private @NonNull @Column(unique = true)  String prefix;

    public PrefixEntity(){}

    public PrefixEntity(String prefix){
        this.prefix=prefix;
    }

}