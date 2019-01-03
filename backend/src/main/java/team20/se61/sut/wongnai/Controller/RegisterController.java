package team20.se61.sut.wongnai.Controller;

import team20.se61.sut.wongnai.Entity.ProfilesEntity;
import team20.se61.sut.wongnai.Entity.SexEntity;
import team20.se61.sut.wongnai.Entity.PrefixEntity;
import team20.se61.sut.wongnai.Entity.ContactEntity;
import team20.se61.sut.wongnai.Repository.SexRepository;
import team20.se61.sut.wongnai.Repository.PrefixRepository;
import team20.se61.sut.wongnai.Repository.ContactRepository;
import team20.se61.sut.wongnai.Repository.ProfilesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;



@EnableAutoConfiguration
@RestController
@CrossOrigin("http://localhost:4200")
public class RegisterController {
    String message;
    @Autowired
    private ProfilesRepository profilesRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private PrefixRepository prefixRepository;
    @Autowired
    private SexRepository sexRepository;

    @GetMapping("/prefix")
    public Collection<PrefixEntity> prefixapi() {
        return prefixRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/sex")
    public Collection<SexEntity> sexapi() {
        return sexRepository.findAll().stream().collect(Collectors.toList());
    }


    @PostMapping("/addprofiles")
    @ResponseBody
    public String newProfiles(@RequestBody() Map<String, Object> body) {

        String email = body.get("email").toString();
        String passworg = body.get("password").toString();
        String name = body.get("name").toString();
        String telephonenumber = body.get("telephonenumber").toString();
        String address = body.get("address").toString();
        String prefix = body.get("prefix").toString();
        String sex = body.get("sex").toString();

        if(validation(email, passworg, name,telephonenumber,address,prefix,sex )!=true){
            return message;
        }
        else{

            if(validationUniqeEmail(prefix,sex,name,passworg,email)!=true){

                return "emailนี้ ลงทะเบียนไปแล้ว กรุณาใช้ email อื่น";
            }

            if(validationUniqeTelephonenumber(address,telephonenumber)!=true){

                return "เบอร์โทรศัพท์นี้ ลงทะเบียนไปแล้ว กรุณาใช้ เบอร์โทรศัพท์อื่น";
            }

        }
        message = "บันทึกเรียบร้อย";
        return message;
    }

    ProfilesEntity profilesEntity = new ProfilesEntity();
    public boolean validationUniqeEmail(String prefix,String sex,String name,String passworg,String email){

        try{
            PrefixEntity prefixEntity = prefixRepository.findByPrefix(prefix);
            SexEntity sexEntity = sexRepository.findBySex(sex);
            profilesEntity.setPrefix(prefixEntity);
            profilesEntity.setSex(sexEntity);
            profilesEntity.setEmail(email);
            profilesEntity.setPassword(passworg);
            profilesEntity.setName(name);
            profilesRepository.save(profilesEntity);
        }

        catch (Exception e){
            return false;
        }

       return true;
    }

    public boolean validationUniqeTelephonenumber(String address,String telephonenumber){
        try{
            ContactEntity contactEntity = new ContactEntity();
            contactEntity.setAddress(address);
            contactEntity.setTelephonenumber(telephonenumber);
            contactEntity.setProfilesEntity(profilesEntity);
            contactRepository.save(contactEntity);
        }

        catch (Exception e){
            profilesRepository.delete(profilesEntity);
            return false;
        }

        return true;
    }

    public boolean validation(String email,String  passworg,String  name,
                              String telephonenumber,String address,String prefix,
                              String sex){

        if(validationEmail(email)==false)
              return false;
        if(validationPassword(passworg)==false)
            return false;
        if(validationPrefix(prefix)==false)
            return false;
        if(validationName(name)==false)
            return false;
        if(validationSex(sex)==false)
            return false;
        if(validationAddress(address)==false)
            return false;
        if(validationTelephonenumber(telephonenumber)==false)
            return false;
        return true;
    }

    public boolean validationSex(String sex){

        try{
            SexEntity sexEntity = sexRepository.findBySex(sex);
        }
        catch (Exception e){
            message = "ไม่มีเพศในฐานข้อมูล";
            return false;
        }
        return true;
    }

    public boolean validationPrefix(String prefix){

        try{
            PrefixEntity prefixEntity = prefixRepository.findByPrefix(prefix);
        }
        catch (Exception e){
            message = "ไม่มีคำนำหน้าในฐานข้อมูล";
            return false;
        }
        return true;
    }

    public boolean validationTelephonenumber(String telephonenumber){
        if(telephonenumber.length()<9||telephonenumber.length()>12){
            message = "เบอร์โทรศัพท์ต้องมีความยาว 9 -12 ตัวอักษร";
            return false;
        }

        if (telephonenumber.charAt(0)!='+'&&(!Character.isDigit(telephonenumber.charAt(0)))){
            message = "เบอร์โทรศัพท์ตัวแรกต้องมีเป็นตัวเลขหรือ + เท่านั้น";
            return false;
        }

        for(int i=1;i<telephonenumber.length();i++){
            if(!Character.isDigit(telephonenumber.charAt(i))){
                message = "เบอร์โทรศัพท์ต้องเป็นตัวเลขเท่านั้น และตัวแรกสามารถเป็น + ได้";
                return false;
            }

        }
            return true;
    }

    public boolean validationPassword(String password){

        if(password.length()<8){
            message = "รหัสผ่านต้องมีความยาว ไม่น้อยกว่า 8 อักษร";
            return  false;
        }

        return true;
    }
    public boolean validationAddress(String address){

        if(address.length()<20){
            message = "ที่อยู่ต้องมีความยาว ไม่น้อยกว่า 20 อักษร";
            return  false;
        }

        return true;
    }

    public boolean validationName(String name){
        for(int i=0;i<name.length();i++){
            if((name.charAt(i)<'a'||name.charAt(i)>'z')&&(name.charAt(i)<'A'||name.charAt(i)>'Z')
                    &&(name.charAt(i)<'ก'||name.charAt(i)>'ฮ')
                    &&(name.charAt(i)<'่'||name.charAt(i)>'๋')
                    &&name.charAt(i)!='ุ'&&name.charAt(i)!='ู'&&name.charAt(i)!='ไ'&&name.charAt(i)!='ึ'
                    &&name.charAt(i)!='ำ'&&name.charAt(i)!='โ'&&name.charAt(i)!='เ'&&name.charAt(i)!='็'
                    &&name.charAt(i)!='า'&&name.charAt(i)!='แ'&&name.charAt(i)!='ิ'&&name.charAt(i)!='ื'
                    &&name.charAt(i)!='์'&&name.charAt(i)!='ี'&&name.charAt(i)!='ใ'){
                message = "ชื่อและนามสกุลต้องไม่มีอักษรพิเศษ";
                return false;

            }
        }

        return  true;
    }

    public boolean validationEmail(String email){


        String EMAIL = email.toUpperCase();
        int last = email.length();
        if (EMAIL.charAt(last-4)!='.'||EMAIL.charAt(last-3)!='C'||EMAIL.charAt(last-2)!='O'||EMAIL.charAt(last-1)!='M'){

            message = "email ต้องลงท้ายด้วย .com หรือ .COM";
            return false;
        }

        int count=0;

        for(int i=0;i<EMAIL.length();i++){
            if(EMAIL.charAt(i)=='@')
                count++;
        }


        if(count!=1){

            message="email ต้องมี @ 1 อักษร";
            return false;
        }

        return true;
    }
}




