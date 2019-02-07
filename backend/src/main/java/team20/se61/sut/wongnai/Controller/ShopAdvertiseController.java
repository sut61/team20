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
public class ShopAdvertiseController {

    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private AdvertisePackageRepository advertisePackageRepository;
    @Autowired
    private ProfilesRepository profilesRepository;
    @Autowired
    private BusinessRepository businessRepository;
    @Autowired
    private ShopAdvertiseRepository shopAdvertiseRepository;

    @GetMapping("/StoreAdvertise/{email}")
    public Collection<Store> tag(@PathVariable String email) {
        return storeRepository.findByBusiness(businessRepository.findByProfile(profilesRepository.findByEmail(email)));
    }

    @GetMapping("/AdvertisePackage")
    public Collection<AdvertisePackage> getAllPackages() {
        return advertisePackageRepository.findAll();
    }

    @GetMapping("/ShopAdvertise")
    public Collection<ShopAdvertise> getShopAdvertise() {
        return shopAdvertiseRepository.findAll();
    }

    @PostMapping("/RegiterShopAdvertise")
    public ShopAdvertise regiterShopAdvertise(@RequestBody Map<String, String> body) {
        ShopAdvertise shopAdvertise = new ShopAdvertise();
        shopAdvertise.setDetail(body.get("detail").toString());
        shopAdvertise.setName(body.get("name").toString());
        shopAdvertise.setImgUrl(body.get("imgUrl").toString());
        shopAdvertise.setAdvertisePackage(advertisePackageRepository.findById(Long.valueOf(body.get("packageId").toString())).get());
        shopAdvertise.setStore(storeRepository.findById(Long.valueOf(body.get("storeId").toString())).get());
        return shopAdvertiseRepository.save(shopAdvertise);
    }
}