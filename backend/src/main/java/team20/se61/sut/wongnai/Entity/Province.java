package team20.se61.sut.wongnai.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;

@Entity
@Getter @Setter
public class Province {
    @Id
    @SequenceGenerator(name="Province_seq",sequenceName="Province_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Province_seq")
    private Long id;
    private String name;
    public Province(){}


}