package team20.se61.sut.wongnai.DataLoader;
import team20.se61.sut.wongnai.Entity.*;
import team20.se61.sut.wongnai.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
@Component
public class PromotionDataloader implements ApplicationRunner {

    // @Autowired
    // private StoreRepository storeRepository;
    // @Autowired
    // private PromotionRepository promotionRepository;
    // @Autowired
    // private ProfilesRepository profilesRepository;
    // @Autowired
    // private BusinessRepository businessRepository;
    @Autowired
    private PromotionTypeRepository promotionTypeRepository;
    @Autowired
    private PercentageRepository percentageRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        PromotionType p1 = new PromotionType();
        p1.setName("รายวัน");
        promotionTypeRepository.save(p1);

        PromotionType p2 = new PromotionType();
        p2.setName("รายเดือน");
        promotionTypeRepository.save(p2);

        
        PromotionType p3 = new PromotionType();
        p3.setName("รายปี");
        promotionTypeRepository.save(p3);

        PromotionType p4 = new PromotionType();
        p4.setName("อีเว้นท์");
        promotionTypeRepository.save(p4);


        Percentage per1 = new Percentage();
        per1.setName(5L);
        percentageRepository.save(per1);

        Percentage per2 = new Percentage();
        per2.setName(10L);
        percentageRepository.save(per2);

        Percentage per3 = new Percentage();
        per3.setName(15L);
        percentageRepository.save(per3);

        Percentage per4 = new Percentage();
        per4.setName(20L);
        percentageRepository.save(per4);

        Percentage per5 = new Percentage();
        per5.setName(25L);
        percentageRepository.save(per5);

        Percentage per6 = new Percentage();
        per6.setName(30L);
        percentageRepository.save(per6);

        Percentage per7 = new Percentage();
        per7.setName(35L);
        percentageRepository.save(per7);

        Percentage per8 = new Percentage();
        per8.setName(40L);
        percentageRepository.save(per8);

        Percentage per9 = new Percentage();
        per9.setName(45L);
        percentageRepository.save(per9);

        Percentage per10 = new Percentage();
        per10.setName(50L);
        percentageRepository.save(per10);

        Percentage per11 = new Percentage();
        per11.setName(70L);
        percentageRepository.save(per11);

        Percentage per12 = new Percentage();
        per12.setName(80L);
        percentageRepository.save(per12);
	}
    
}