package team20.se61.sut.wongnai.Entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name="Contact")
public class ContactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long contactid;
    private @NonNull  String address;
    private @NonNull @Column(unique = true) String telephonenumber;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "profilesid", insertable = true,unique = true)
    @NonNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ProfilesEntity profilesEntity;


}