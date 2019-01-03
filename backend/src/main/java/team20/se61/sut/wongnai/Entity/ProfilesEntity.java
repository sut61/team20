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
@NoArgsConstructor
@Table(name="Profiles")
public class ProfilesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long profilesid;
    private @NonNull String name;
    private @NonNull String email;
    private @NonNull String password;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = SexEntity.class)
    @JoinColumn(name="sexid",insertable = true)
    private @NonNull SexEntity sex;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PrefixEntity.class)
    @JoinColumn(name="prefixid",insertable = true)
    private @NonNull PrefixEntity prefix;



}