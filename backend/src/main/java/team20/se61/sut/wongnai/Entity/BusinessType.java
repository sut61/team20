package team20.se61.sut.wongnai.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;

@Entity
@Getter @Setter
public class BusinessType {
    @Id
    @SequenceGenerator(name="BusinessType_seq",sequenceName="BusinessType_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BusinessType_seq")
    private Long id;
    private String name;
    public BusinessType(){}
}