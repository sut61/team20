package team20.se61.sut.wongnai.Controller;

import team20.se61.sut.wongnai.Entity.*;
import team20.se61.sut.wongnai.Repository.*;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
class OrderFoodController {
    
    @Autowired private OrderFoodRepository orderFoodRepository;
    @Autowired private FoodRepository foodRepository;
    @Autowired private ProfilesRepository profilesRepository;
    @Autowired private StoreRepository storeRepository;

    public OrderFoodController () {
    }

    @GetMapping("/Food")
    public Collection<Food> foods(){
        return foodRepository.findAll();
    }

    @GetMapping("/FoodOrder")
    public Collection<OrderFood> orderFoods() {
        return orderFoodRepository.findAll();
    }

    @PostMapping("/Order/{profileId}/{storeId}/{foodId}/{countItem}/{totalPrice}")
    public OrderFood newOrder(@PathVariable Long profileId, @PathVariable Long storeId, @PathVariable Long foodId, @PathVariable Integer countItem, @PathVariable Integer totalPrice) {
        OrderFood newOrder = new OrderFood();
        newOrder.setProfile(profilesRepository.findById(profileId).get());
        newOrder.setStore(storeRepository.findById(storeId).get());
        newOrder.setFood(foodRepository.findById(foodId).get());
        newOrder.setCountItem(countItem);
        newOrder.setTotalPrice(totalPrice);
        return orderFoodRepository.save(newOrder);
    }
}
