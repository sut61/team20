package team20.se61.sut.wongnai.Entity;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "report_tag")
public class ReportTag{
    @Id
    @SequenceGenerator(name="ReportTag_seq",sequenceName="ReportTag_seq")               
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ReportTag_seq")
    private long id;
   
    @ManyToOne()   
    @JoinColumn(name= "tagId")     
    private Tag tag;

    @ManyToOne()   
    @JoinColumn(name= "reportId")     
    private ReportProblem reportProblem;

}