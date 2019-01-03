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
@Table(name="Contact")
public class ContactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long contactid;
    private @NonNull String address;
    private @NonNull String telephonenumber;

}