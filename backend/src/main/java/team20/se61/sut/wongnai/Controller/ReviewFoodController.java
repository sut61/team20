package team20.se61.sut.wongnai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import team20.se61.sut.wongnai.Entity.FoodForReviewEntity;
import team20.se61.sut.wongnai.Entity.PointFoodEntity;
import team20.se61.sut.wongnai.Entity.ProfilesEntity;
import team20.se61.sut.wongnai.Entity.Restaurant;
import team20.se61.sut.wongnai.Repository.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@EnableAutoConfiguration
@RestController
@CrossOrigin("http://localhost:4200")
public class ReviewFoodController {

    @Autowired
    private PointFoodRepository pointFoodRepository;

    @Autowired
    private ProfilesRepository profilesRepository;

    @Autowired
    private Restaurantrepository restaurantrepository;

    @Autowired
    FoodForReviewRepository foodForReviewRepository;

    @GetMapping("/pointfood")
    public Collection<PointFoodEntity> pointfoodpi() {
        return pointFoodRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/foodall")
    public Collection<FoodForReviewEntity> foodpi() {
        return foodForReviewRepository.findAll().stream().collect(Collectors.toList());
    }



    @PostMapping("/addfoodforreview")
    @ResponseBody
    public Map<String, String> newfoodForreview(@RequestBody() Map<String, Object> body) {
        HashMap<String, String> map = new HashMap<>();
        String email = body.get("email").toString();
        String restuarant = body.get("restaurant").toString(); if(restuarant=="") restuarant =null;
        String telephone = body.get("telephone").toString(); if(telephone=="") telephone=null;
        String identity = body.get("identity").toString(); if(identity=="") identity = null;
        String  review = body.get("review").toString(); if (review=="") review = null;
        String  food = body.get("food").toString(); if (food=="") food = null;
        int point,price;
        if((body.get("point").toString())==""){
             map.put("message", "point not null");
            return map;
        }
        else{
             point = Integer.valueOf(body.get("point").toString());
        }
        try{
        if((body.get("price").toString())==""){
            map.put("message", "price not null");
            return map;
        }
        else{
             price = Integer.valueOf(body.get("price").toString());
        }}
        catch(Exception e){
            map.put("message", "want int");
            return map;
        }




        long restaurantid = 0;
    try {
        ProfilesEntity profilesEntity = profilesRepository.findByEmail(email);
        PointFoodEntity pointfood = pointFoodRepository.findByPointfood(point);

        Restaurant restaurantEntitynew = new Restaurant();
        restaurantEntitynew.setIdentity(identity);
        restaurantEntitynew.setTelephonenumber(telephone);
        restaurantEntitynew.setRestaurant(restuarant);
        restaurantrepository.save(restaurantEntitynew);



        Restaurant restaurantEntity = restaurantrepository.findByIdentity(identity);
        restaurantid = restaurantEntity.getRestaurantid();
        FoodForReviewEntity foodForReviewEntity = new FoodForReviewEntity();
        foodForReviewEntity.setFood(food);
        foodForReviewEntity.setPointFood(pointfood);
        foodForReviewEntity.setPrice(price);
        foodForReviewEntity.setProfilesEntity(profilesEntity);
        foodForReviewEntity.setReview(review);
        foodForReviewEntity.setRestaurant(restaurantEntity);
        foodForReviewRepository.save(foodForReviewEntity);

        map.put("message", "save success");
    } catch (javax.validation.ConstraintViolationException e ){

        if(restaurantid!=0) {
            restaurantrepository.deleteById(restaurantid);

        }
        String m[] = e.getMessage().split(java.util.regex.Pattern.quote("'"));
        map.put("message",m[1]);
        return map;

    }
    catch (Exception e) {

        if(restaurantid!=0)
            restaurantrepository.deleteById(restaurantid);
        String m[] = e.getMessage().split(java.util.regex.Pattern.quote("."));
        String m1[]=m[1].split(" ");
        map.put("message",m1[0]);
        return map;

    }

      return map;
    }

}
