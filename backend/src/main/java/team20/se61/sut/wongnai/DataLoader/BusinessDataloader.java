package team20.se61.sut.wongnai.DataLoader;
import team20.se61.sut.wongnai.Entity.*;
import team20.se61.sut.wongnai.Repository.*;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
@Component
public class BusinessDataloader implements ApplicationRunner {

    @Autowired  private  ProvinceRepository provinceRepository;
    @Autowired  private BusinessTypeRepository businessTypeRepository;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {

        
        Stream.of("กระบี่","กรุงเทพมหานคร","กาญจนบุรี","กาฬสินธุ์","กำแพงเพชร","ขอนแก่น","จันทบุรี","ฉะเชิงเทรา" ,"ชลบุรี","ชัยนาท","ชัยภูมิ","ชุมพร","เชียงราย","เชียงใหม่","ตรัง","ตราด","ตาก","นครนายก","นครปฐม","นครพนม","นครราชสีมา" ,"นครศรีธรรมราช","นครสวรรค์","นนทบุรี","นราธิวาส","น่าน","บุรีรัมย์","บึงกาฬ","ปทุมธานี","ประจวบคีรีขันธ์","ปราจีนบุรี","ปัตตานี" ,"พะเยา","พังงา","พัทลุง","พิจิตร","พิษณุโลก","เพชรบุรี","เพชรบูรณ์","แพร่","ภูเก็ต","มหาสารคาม","มุกดาหาร","แม่ฮ่องสอน" ,"ยโสธร","ยะลา","ร้อยเอ็ด","ระนอง","ระยอง","ราชบุรี","ลพบุรี","ลำปาง","ลำพูน","เลย","ศรีสะเกษ","สกลนคร","สงขลา" ,"สตูล","สมุทรปราการ","สมุทรสงคราม","สมุทรสาคร","สระแก้ว","สระบุรี","สิงห์บุรี","สุโขทัย","สุพรรณบุรี","สุราษฎร์ธานี" ,"สุรินทร์","หนองคาย","หนองบัวลำภู","อยุธยา","อ่างทอง","อำนาจเจริญ","อุดรธานี","อุตรดิตถ์","อุทัยธานี","อุบลราชธานี").forEach(provinceName -> { 
            Province province = new Province();
            province.setName(provinceName);
            provinceRepository.save(province);
        });

        Stream.of("ร้านอาหาร-ไม่มีสาขา","ร้านอาหาร-มีสาขา","ที่พัก","สถานที่ท่องเที่ยว","คลิกนิก สปา ซาลอน - ไม่มีสาขา","คลิกนิก สปา ซาลอน - มีสาขา").forEach(nameType -> { 
            BusinessType businessType = new BusinessType();
            businessType.setName(nameType);
            businessTypeRepository.save(businessType);
        });
        
        provinceRepository.findAll().forEach(System.out::println);
        businessTypeRepository.findAll().forEach(System.out::println);
	}
    
}