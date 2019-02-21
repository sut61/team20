package team20.se61.sut.wongnai.Entity;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "Room")
public class Room{
    @Id
    @SequenceGenerator(name="Room_seq",sequenceName="Room_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Room_seq")
    private long id;
    @Column(name="name",unique = true, nullable = true)
    @NotNull(message = "roomName must NotNull")
    private String name;
    
    public Room(String name){
        this.name = name;
    }
}