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

import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;




@EnableAutoConfiguration
@RestController
@CrossOrigin("http://localhost:4200")
public class RegisterController {



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
    public Map<String, String> newProfiles(@RequestBody() Map<String, Object> body) {
        HashMap<String, String> map = new HashMap<>();
        String email = body.get("email").toString();
        if(email=="")
            email=null;
        String password = body.get("password").toString();
        if(password=="")
            password=null;

        String name = body.get("name").toString();
            if(name=="")
                name=null;
        String telephonenumber = body.get("telephonenumber").toString();
        if(telephonenumber=="")
            telephonenumber=null;
        String address = body.get("address").toString();
         if(address=="")
             address=null;
        String prefix = body.get("prefix").toString();
        if(prefix=="")
            prefix=null;
        String sex = body.get("sex").toString();
        if(sex=="")
            sex=null;
        long contactid= 0;

        try {
            PrefixEntity prefixEntity = prefixRepository.findByPrefix(prefix);
            SexEntity sexEntity = sexRepository.findBySex(sex);
            ContactEntity contactEntity = new ContactEntity();
            contactEntity.setAddress(address);
            contactEntity.setTelephonenumber(telephonenumber);
            contactRepository.save(contactEntity);
            ContactEntity contactEntity1 = contactRepository.findByTelephonenumber(telephonenumber);
            contactid = contactEntity1.getContactid();
            ProfilesEntity profilesEntity = new ProfilesEntity();
            profilesEntity.setPrefix(prefixEntity);
            profilesEntity.setSex(sexEntity);
            profilesEntity.setContact(contactEntity);
            profilesEntity.setEmail(email);
            profilesEntity.setPassword(password);
            profilesEntity.setName(name);
            profilesRepository.save(profilesEntity);
            map.put("message", "บันทึกเรียบร้อย");
        } catch (javax.validation.ConstraintViolationException e ){

            if(contactid!=0)
            contactRepository.deleteById(contactid);
            String m[] = e.getMessage().split(java.util.regex.Pattern.quote("'"));
            map.put("message",m[1]);
            return map;

        }
    catch (Exception e) {

        if(contactid!=0)
            contactRepository.deleteById(contactid);
        String m[] = e.getMessage().split(java.util.regex.Pattern.quote("."));
        String m1[]=m[1].split(" ");
        map.put("message",m1[0]);
        return map;

    }

        return map;
    }

}



