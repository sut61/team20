package team20.se61.sut.wongnai.DataLoader;
import team20.se61.sut.wongnai.Entity.*;
import team20.se61.sut.wongnai.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
@Component
public class ShopAdvertiseDataloader implements ApplicationRunner {

    @Autowired  private AdvertisePackageRepository advertisePackageRepository;
    // @Autowired  private  StoreRepository storeRepository;
    // @Autowired  private ProfilesRepository profilesRepository;
    // @Autowired  private BusinessRepository businessRepository;
    // @Autowired  private ShopAdvertiseRepository shopAdvertiseRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        advertisePackageRepository.save(new AdvertisePackage("7 วัน",1500D)); 
        advertisePackageRepository.save(new AdvertisePackage("10 วัน",3000D));
        advertisePackageRepository.save(new AdvertisePackage("30 วัน",5000D));
        advertisePackageRepository.save(new AdvertisePackage("90 วัน",12000D));
        advertisePackageRepository.save(new AdvertisePackage("365 วัน",30000D));
        advertisePackageRepository.findAll().forEach(System.out::println);
	}
    
}