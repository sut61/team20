package team20.se61.sut.wongnai.Controller;

import java.util.Collection;
import java.util.Map;
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
public class PromotionController {

    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private PromotionRepository promotionRepository;
    @Autowired
    private ProfilesRepository profilesRepository;
    @Autowired
    private BusinessRepository businessRepository;
    @Autowired
    private PromotionTypeRepository promotionTypeRepository;
    @Autowired
    private PercentageRepository percentageRepository;

    @GetMapping("/PromotionStore/{email}")
    public Collection<Store> tag(@PathVariable String email) {
        return storeRepository.findByBusiness(businessRepository.findByProfile(profilesRepository.findByEmail(email)));
    }

    @GetMapping("/Percentage")
    public Collection<Percentage> getPercentage() {
        return percentageRepository.findAll();
    }

    @GetMapping("/PromotionType")
    public Collection<PromotionType> getPromotionType() {
        return promotionTypeRepository.findAll();
    }

    @PostMapping("/Promotion")
    public Promotion regiterShopAdvertise(@RequestBody Map<String, String> body) {
        Promotion promotion = new Promotion();
        Store store = storeRepository.findById(Long.valueOf(body.get("storeId").toString())).get();
        PromotionType promotionType = promotionTypeRepository.findById(Long.valueOf(body.get("promotionTypeId").toString())).get();
        Percentage percentage = percentageRepository.findById(Long.valueOf(body.get("percentageId").toString())).get();
        
        promotion.setName(body.get("name").toString());
        promotion.setDetail(body.get("detail").toString());
        promotion.setStore(store);
        promotion.setPromotionType(promotionType);
        promotion.setPercentage(percentage);
        return promotionRepository.save(promotion);
    }
}