package team20.se61.sut.wongnai.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team20.se61.sut.wongnai.Entity.Business;
import team20.se61.sut.wongnai.Entity.DayOfWeek;
import team20.se61.sut.wongnai.Entity.NumberOfSeat;
import team20.se61.sut.wongnai.Entity.PriceRange;
import team20.se61.sut.wongnai.Entity.Store;
import team20.se61.sut.wongnai.Repository.BusinessRepository;
import team20.se61.sut.wongnai.Repository.DayOfWeekRepository;
import team20.se61.sut.wongnai.Repository.NumberOfSeatRepository;
import team20.se61.sut.wongnai.Repository.PriceRangeRepository;
import team20.se61.sut.wongnai.Repository.ProfilesRepository;
import team20.se61.sut.wongnai.Repository.StoreRepository;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/store")
public class StoreController {
    @Autowired private StoreRepository storeRepository;
    @Autowired private NumberOfSeatRepository numberOfSeatRepository;
    @Autowired private PriceRangeRepository priceRangeRepository;
    @Autowired private BusinessRepository businessRepository;
    @Autowired private ProfilesRepository profilesRepository;
    @Autowired private DayOfWeekRepository dayOfWeekRepository;

    @GetMapping()
    public List<Store> Stores() {
        return storeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Store> Stores(@PathVariable Long id) {
        return storeRepository.findById(id);
    }

    @GetMapping("/numberofseat")
    public List<NumberOfSeat> NumberOfSeats() {
        return numberOfSeatRepository.findAll();
    }

    @GetMapping("/pricerange")
    public List<PriceRange> PriceRanges() {
        return priceRangeRepository.findAll();
    }

    @GetMapping("/dayOfWeek")
    public List<DayOfWeek> dayOfWeek() {
        return dayOfWeekRepository.findAll();
    }

    @PostMapping("/{dayIdList}")
    public Store AddStore(Store newStore,@PathVariable List<Long> dayIdList, @RequestBody Map<String, String> body) {
        Optional<NumberOfSeat> numberOfSeat = numberOfSeatRepository.findById(Long.valueOf(body.get("numberOfSeat")));
        Optional<PriceRange> priceRange = priceRangeRepository.findById(Long.valueOf(body.get("priceRange")));
        Business business = businessRepository.findByProfile(profilesRepository.findByEmail(body.get("email")));

        newStore.setName(body.get("name"));
        newStore.setBranch(body.get("branch"));
        newStore.setPriceRange(priceRange.get());
        newStore.setBusiness(business);

        newStore.setAdddress(body.get("adddress"));
        newStore.setHint(body.get("hint"));
        newStore.setProvince(body.get("province"));
        newStore.setDistrict(body.get("district"));
        newStore.setSubDistrict(body.get("subDistrict"));
        newStore.setBuilding(body.get("building"));

        newStore.setPhone(body.get("phone"));
        newStore.setEmail(body.get("email"));
        newStore.setWebsite(body.get("website"));
        
        newStore.setNumberOfSeat(numberOfSeat.get());

        Set<DayOfWeek> dayOfWeeks = new HashSet<DayOfWeek>();
        Set<Store> store = new HashSet<Store>();
        store.add(newStore);
        for(Long i : dayIdList){
            DayOfWeek dayOfWeek = dayOfWeekRepository.findById(i).get();
            dayOfWeeks.add(dayOfWeek);
        }
        newStore.setDayOfWeeks(dayOfWeeks);
        newStore.setOpenTime(body.get("openTime"));
        newStore.setOpenTime(body.get("closeTime"));
        
        newStore.setImage(body.get("image"));

        return storeRepository.save(newStore);
    }
    
}