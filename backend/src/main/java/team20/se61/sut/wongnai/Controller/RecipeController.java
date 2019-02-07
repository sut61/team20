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
@RequestMapping("/Recipe")
class RecipeController{ 

        @Autowired private RecipeRespository recipeRespository;
        @Autowired private CookingMethodRespository cookingMethodRespository;
        @Autowired private FoodTypeRespository foodTypeRespository;
        @Autowired private MainIngredRespository mainIngredRespository;
        @Autowired private ProfilesRepository profilesRepository;

        public RecipeController(RecipeRespository recipeRespository){
            this.recipeRespository=recipeRespository;

        }

        @GetMapping()
        public Collection<Recipe> recipes() {
            return recipeRespository.findAll().stream()
                    .collect(Collectors.toList());
        }

        @GetMapping("/{id}")
        public Optional<Recipe> findRecipe(@PathVariable Long id) {

            return recipeRespository.findById(id); 

    }
 @PostMapping()
        public Recipe addRecipe(Recipe hotRecipe, @RequestBody Map<String, Object> body) {
             
            Optional<CookingMethod> cookingMethod = cookingMethodRespository.findById(Long.valueOf(body.get("cookingMethod").toString()));
            Optional<FoodType> foodType = foodTypeRespository.findById(Long.valueOf(body.get("foodType").toString()));
            Optional<MainIngredients> mainIngred = mainIngredRespository.findById(Long.valueOf(body.get("mainIngred").toString()));
            ProfilesEntity profilesEntity = profilesRepository.findByEmail(body.get("email").toString());

            hotRecipe.setProfilles(profilesEntity);
            hotRecipe.setCookingmethod(cookingMethod.get());
            hotRecipe.setFoodtype(foodType.get());
            hotRecipe.setMainingred(mainIngred.get());
            hotRecipe.setUrlPhoto(body.get("UrlPhoto").toString());
            hotRecipe.setName(body.get("foodname").toString());
            hotRecipe.setHowto(body.get("howto").toString());
            return recipeRespository.save(hotRecipe);
           
    }

        @DeleteMapping("delete/{id}")
        public  boolean deleteRecipe(@PathVariable  Long id) {
            try {
            recipeRespository.deleteById(id); 
                return true;
            }catch(Exception e) {
                return false;
            }

    }
        @PutMapping("update")
        public  Recipe updateRecipe(@RequestBody Recipe body) {
            try{    
            return recipeRespository.save(body);
            }catch(Exception e){
                return null;
            }
        
    }

}
