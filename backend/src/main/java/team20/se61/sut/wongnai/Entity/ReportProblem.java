package team20.se61.sut.wongnai.Entity;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Set;
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

    @ManyToOne()
    @JoinColumn(name= "userId")     
    private ProfilesEntity user;

    @ManyToMany
    @JoinTable(name = "has_tag", joinColumns = @JoinColumn(name = "report_id", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
	private Set<Tag> tags;

    public ReportProblem(String title, Set<Tag> tags){
        this.title = title;
        this.tags = tags;
    }
}