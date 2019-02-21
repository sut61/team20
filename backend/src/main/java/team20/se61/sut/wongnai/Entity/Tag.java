package team20.se61.sut.wongnai.Entity;
import java.util.Set;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.*;
@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "Tag")
public class Tag{
    @Id
    @SequenceGenerator(name="Tag_seq",sequenceName="Tag_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Tag_seq")
    private long id;
    @Column(name="name",unique = true, nullable = true)
    @NotNull(message = "tagName must NotNull")
    private String name;

    public Tag(String name){
        this.name = name;
    }
    @ManyToMany(mappedBy = "tags")
    @JsonBackReference
    private Set<ReportProblem> reports;        
}