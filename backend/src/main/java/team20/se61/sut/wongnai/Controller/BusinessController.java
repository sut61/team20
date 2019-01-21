package team20.se61.sut.wongnai.Controller;

import team20.se61.sut.wongnai.Entity.*;
import team20.se61.sut.wongnai.Repository.*;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
class BusinessController{
    @Autowired private  BusinessRepository businessRepository;
    @Autowired private BusinessTypeRepository businessTypeRepository;
    @Autowired private ProvinceRepository provinceRepository;
    @Autowired private ProfilesRepository profilesRepository;
    

    @GetMapping("/Business")
    public Collection<Business> getBusiness(){
        return businessRepository.findAll();
    
    }
    @GetMapping("/BusinessType")
    public Collection<BusinessType> getBusinessType(){
        return businessTypeRepository.findAll();
    
    }
    @GetMapping("/Province")
    public Collection<Province> getProvince(){
        return provinceRepository.findAll();
    
    }
    @PostMapping("/Business/Register")
    public Business newBusiness(@RequestBody Map<String, Object> body){
        Business newBusiness = new Business();
        newBusiness.setProfile(profilesRepository.findByEmail(body.get("userEmail").toString()));
        newBusiness.setType(businessTypeRepository.findById(Long.valueOf(body.get("BusinessTypeId").toString())).get());
        newBusiness.setProvince(provinceRepository.findById(Long.valueOf(body.get("provinceId").toString())).get());
        newBusiness.setDistrict(body.get("district").toString());
        newBusiness.setEmail(body.get("email").toString());
        newBusiness.setShopName(body.get("shopName").toString());
        newBusiness.setTel(body.get("tel").toString());
        return businessRepository.save(newBusiness);
    }

}

