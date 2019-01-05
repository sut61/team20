package team20.se61.sut.wongnai.Entity;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Collection;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "ReportProblem")
public class ReportProblem{
    @Id
    @SequenceGenerator(name="ReportProblem_seq",sequenceName="ReportProblem_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ReportProblem_seq")
    private long id;
    private @NonNull String title;
    private String detail;
    private String imgUrl;

    @ManyToOne()   
    @JoinColumn(name= "roomId")     
    private Room room;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore 
    private Collection<ReportTag> reportTag = new ArrayList<ReportTag>();
}