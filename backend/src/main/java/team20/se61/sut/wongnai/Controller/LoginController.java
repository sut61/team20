package team20.se61.sut.wongnai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import team20.se61.sut.wongnai.Entity.ProfilesEntity;
import team20.se61.sut.wongnai.Repository.ProfilesRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@EnableAutoConfiguration
@RestController
@CrossOrigin("http://localhost:4200")
public class LoginController {

    String name;

    @Autowired
    ProfilesRepository profilesRepository;
    @PostMapping("/validate")
    @ResponseBody
    public Map<String, String> login(@RequestBody() Map<String, Object> body) {
        String email = body.get("email").toString();
        String password = body.get("password").toString();
        HashMap<String,String> map = new HashMap<>();
        ProfilesEntity profilesEntity = profilesRepository.findByEmail(email);
      try{

            if(profilesEntity.getPassword().equals(password))
                map.put("message","true");
            else
                map.put("message","false");
        }
        catch (Exception e){

            map.put("message","false");
        }


             return map;

    }
}
