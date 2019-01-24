package team20.se61.sut.wongnai.Entity;
import java.util.Set;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.*;
@Entity
@Getter @Setter
@NoArgsConstructor
public class DayOfWeek{
    @Id            
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name="name",unique = true, nullable = true)
    private @NonNull String name;

    @ManyToMany(mappedBy = "dayOfWeeks")
    @JsonBackReference
    private Set<Store> store;  

    public DayOfWeek(String name){
        this.name = name;
    }
          
}