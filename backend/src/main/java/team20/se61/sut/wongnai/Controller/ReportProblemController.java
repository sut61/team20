package team20.se61.sut.wongnai.Controller;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import team20.se61.sut.wongnai.Entity.*;
import team20.se61.sut.wongnai.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReportProblemController{
    @Autowired  private  TagRepository tagRepository;
    @Autowired  private RoomRepository roomRepository;
    @Autowired  private ReportProblemRepository reportProblemRepository;
    @Autowired private ProfilesRepository profilesRepository;
    // @Autowired private User userRepository;

    @GetMapping("/Tag")
    public Collection<Tag> tag(){
        return tagRepository.findAll();
    }

    @GetMapping("/Room")
    public Collection<Room> room(){
        return roomRepository.findAll();
    }

    @GetMapping("/ReportProblem")
    public Collection<ReportProblem> reportProblem(){
        return reportProblemRepository.findAll();
    }
    
    @GetMapping("/ReportProblem/{id}")
    public Optional<ReportProblem> reportProblemid(@PathVariable Long id){
        return reportProblemRepository.findById(id);
    }

    @PostMapping("/ReportProblem/{tagIdList}")
    public ReportProblem newReport(@PathVariable List<Long> tagIdList,@RequestBody() Map<String,Object> body){
        ReportProblem newreport= new ReportProblem();
        newreport.setDetail(body.get("detail").toString());
        newreport.setTitle(body.get("title").toString());
        newreport.setImgUrl(body.get("imgUrl").toString());
        newreport.setRoom(roomRepository.findById(Long.valueOf(body.get("roomId").toString())).get());
        newreport.setUser(profilesRepository.findByEmail(body.get("email").toString()));

        //หา tag ตาม array ที�?ส�?�?เ�?�?ามา
        Set<Tag> tags = new HashSet<Tag>();
        Set<ReportProblem> reports = new HashSet<ReportProblem>();
        reports.add(newreport);
        for(Long i : tagIdList){
            Tag tag = tagRepository.findById(i).get();
            tags.add(tag);
            tag.setReports(reports);
            tagRepository.save(tag);
        }
        newreport.setTags(tags);
        return reportProblemRepository.save(newreport);
     }
}