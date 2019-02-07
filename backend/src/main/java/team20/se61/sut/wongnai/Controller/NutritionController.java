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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
class NutritionController{

    @Autowired private RecipeRespository recipeRespository;
    @Autowired private FoodpropertiesRepository foodpropRepo;
    @Autowired private NutritivevalueRepository NutriRepo;

    public  NutritionController( FoodpropertiesRepository foodpropRepo,NutritivevalueRepository NutriRepo){
        this.NutriRepo=NutriRepo;
        this.foodpropRepo=foodpropRepo;   
    }

    @GetMapping("/Fooprop/{id}")
    public Optional<Foodproperties> findFooprop(@PathVariable Long id) {
        return foodpropRepo.findByRecipe_id(id);
    }

    @GetMapping("/Nutritive/{id}")  
    public Optional<Nutritive_value> Nutritivevalue(@PathVariable Long id) {
    return NutriRepo.findByRecipe_id(id); 
    }

    @PostMapping("/add-nutrition")
    public void addnutrition( Foodproperties foodprop ,  Nutritive_value Nutrivalue,@RequestBody Map<String, Object> body) {

        Optional<Recipe> recipe = recipeRespository.findById(Long.valueOf(body.get("Recipe").toString()));

        foodprop.setRecipe(recipe.get());
        foodprop.setFoodproperties(body.get("prop").toString());
        foodpropRepo.save(foodprop);

        Nutrivalue.setRecipe(recipe.get());
        Nutrivalue.setAmount(Long.valueOf(body.get("amount").toString()));
        Nutrivalue.setEnergy(Long.valueOf(body.get("energy").toString()));
        Nutrivalue.setFat(Long.valueOf(body.get("fat").toString()));
        Nutrivalue.setSaturates(Long.valueOf(body.get("saturates").toString()));
        Nutrivalue.setSodium(Long.valueOf(body.get("sodium").toString()));
        Nutrivalue.setSugar(Long.valueOf(body.get("sugar").toString()));
        NutriRepo.save( Nutrivalue);

    }



}