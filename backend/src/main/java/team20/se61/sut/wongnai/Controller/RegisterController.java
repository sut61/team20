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

            PrefixEntity prefixEntity = prefixRepository.findByPrefix(prefix);
            SexEntity sexEntity = sexRepository.findBySex(sex);
            ProfilesEntity profilesEntity = new ProfilesEntity();
            profilesEntity.setPrefix(prefixEntity);
            profilesEntity.setSex(sexEntity);
            profilesEntity.setEmail(email);
            profilesEntity.setPassword(passworg);
            profilesEntity.setName(name);
            profilesRepository.save(profilesEntity);
            ContactEntity contactEntity = new ContactEntity();
            contactEntity.setAddress(address);
            contactEntity.setTelephonenumber(telephonenumber);
            contactEntity.setProfilesEntity(profilesEntity);
            contactRepository.save(contactEntity);



        }
        message = "บันทึกเรียบร้อย";
        return message;
    }

    public boolean validation(String email,String  passworg,String  name,
                              String telephonenumber,String address,String prefix,
                              String sex){

        return validationSex()&&validationPrefix()&&validationEmail()&&
        validationName()&&validationAddress()&&validationTelephonenumber()&&validationPassword();
    }
}




