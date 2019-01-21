package team20.se61.sut.wongnai.DataLoader;
import team20.se61.sut.wongnai.Entity.*;
import team20.se61.sut.wongnai.Repository.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
@Component
public class ReportProblemDataloader implements ApplicationRunner {

    @Autowired  private  TagRepository tagRepository;
    @Autowired  private RoomRepository roomRepository;
    @Autowired  private ReportProblemRepository reportProblemRepository;
    //@Autowired  private ReportTagRepository reportTagRepository;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {

        
        Stream.of("อาหาร","อาหารไทย","อาหารต่างประเทศ","ของหวาน","กาแฟ","อาหารทะเล","พิซซ่า","บุฟเฟ่ปิ้งย่าง").forEach(tagName -> { 
            tagRepository.save(new Tag(tagName));            
        });

        Stream.of("รีวิวร้านอาหาร","เพิ่มร้านค้า","สมัครเป็นร้านค้า","เพิ่มสูตรอาหาร").forEach(roomName -> { 
            roomRepository.save(new Room(roomName));
        });
        
        tagRepository.findAll().forEach(System.out::println);
        roomRepository.findAll().forEach(System.out::println);
        reportProblemRepository.findAll().forEach(System.out::println);
	}
    
}

//SELECT * FROM HAS_TAG ht,REPORT_PROBLEM  rp,TAG t where t.id = ht.tag_id and rp.id = ht.report_id