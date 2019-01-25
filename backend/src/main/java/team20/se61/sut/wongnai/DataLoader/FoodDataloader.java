package team20.se61.sut.wongnai.DataLoader;
import team20.se61.sut.wongnai.Entity.*;
import team20.se61.sut.wongnai.Repository.*;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
@Component
public class FoodDataloader implements ApplicationRunner {

    @Autowired private ProvinceRepository provinceRepository;
    @Autowired private BusinessTypeRepository businessTypeRepository;
    @Autowired private BusinessRepository businessRepository;
    @Autowired private CookingMethodRespository cookingMethodRespository;
    @Autowired private FoodTypeRespository foodTypeRespository;
    @Autowired private MainIngredRespository mainIngredRespository;
    @Autowired private RecipeRespository recipeRespository;
    @Autowired private PriceRangeRepository priceRangeRepository;
    @Autowired private NumberOfSeatRepository numberOfSeatRepository;
    @Autowired private ContactRepository contactRepository;
    @Autowired private PrefixRepository prefixRepository;
    @Autowired private SexRepository sexRepository;
    @Autowired private ProfilesRepository profilesRepository;
    @Autowired private StoreRepository storeRepository;
    @Autowired private FoodRepository foodRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        

        
        

        NumberOfSeat numSeat = new NumberOfSeat("500");
        numberOfSeatRepository.save(numSeat);

        Province province = new Province();
        province.setName("Sydney");
        provinceRepository.save(province);

        BusinessType newBusinessType = new BusinessType();
        newBusinessType.setName("ขายอยู่ มทส.");
        businessTypeRepository.save(newBusinessType);

        

        Business business = new Business();
        
        business.setDistrict("district");
        business.setEmail("email");
        business.setProvince(province);
        business.setShopName("shopName");
        business.setTel("0888888888");
        business.setType(newBusinessType);
        businessRepository.save(business);

        Store st = new Store();
        st.setAdddress("adddress");
        st.setBranch("branch");
        st.setBuilding("building");
        st.setBusiness(business);
        st.setDistrict("district");
        st.setEmail("email");
        st.setHint("hint");
        st.setImage("https://vignette.wikia.nocookie.net/redvelvet/images/f/f6/The_Red_Summer_Logo.png/revision/latest?cb=20170709132135&format=original");
        st.setName("name");
        st.setNumberOfSeat(numSeat);
        st.setPhone("0000000000");
        storeRepository.save(st);

        String[] foodName = {"เบคอนกรอบ", "น้ำตกไก่", "ฮาวายเอี้ยน", "ซีฟู้ดค็อกเทล", "ซุปเปอร์เดอลุกซ์"};
        String[] foodImage = {"https://1112.minorcdn.com/1112/public/images/products/pizza/website/Pizza-Pan-Crispy-Bacon_New-Toppings_Angle_web.png",
        "https://1112.minorcdn.com/1112/public/images/products/pizza/website/Pizza-Pan-Spicy-Namtok-Chicken_New-Toppings_Angle_web.png",
        "https://1112.minorcdn.com/1112/public/images/products/pizza/website/Pan_Hawaiian.png",
        "https://1112.minorcdn.com/1112/public/images/products/pizza/website/Pan_Seafood-Cocktail.png",
        "https://1112.minorcdn.com/1112/public/images/products/pizza/website/Pan_Super-Deluxe.png"};
        int[] foodPrice = {125,150,175,200,250};

        for (int i = 0; i<5; i++) {
            Food food = new Food();
            food.setName(foodName[i]);
            food.setStore(st);
            food.setImage(foodImage[i]);
            food.setPrice(foodPrice[i]);
            foodRepository.save(food);
        }


        
        provinceRepository.findAll().forEach(System.out::println);
        businessTypeRepository.findAll().forEach(System.out::println);
	}
    
}