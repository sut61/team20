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


    @PostMapping("/add")
    @ResponseBody
    public void newProfiles(@RequestBody() Map<String, Object> body) {
        ProfilesEntity profilesEntity = new ProfilesEntity();
        PrefixEntity prefixEntity = prefixRepository.findByPrefix(body.get("prefix").toString());
        SexEntity sexEntity = sexRepository.findBySex(body.get("sex").toString());
        ContactEntity contactEntity = contactRepository.findByAllergy(body.get("allergy").toString());
        profilesEntity.setPrefix(prefixEntity);
        profilesEntity.setFirstname(body.get("fname").toString());
        profilesEntity.setLastname(body.get("lname").toString());
        profilesEntity.setTelephonenumber(body.get("tel").toString());
        profilesEntity.setSex(sexEntity);
        profilesEntity.setDisease(diseaseEntity);
        profilesRepository.save(profilesEntity);

    }
}




