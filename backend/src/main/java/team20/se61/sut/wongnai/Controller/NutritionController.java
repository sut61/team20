package team20.se61.sut.wongnai.Controller;

import team20.se61.sut.wongnai.Entity.*;
import team20.se61.sut.wongnai.Repository.*;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.HashMap;
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
    public boolean addnutrition( Foodproperties foodprop ,  Nutritive_value Nutrivalue,@RequestBody Map<String, Object> body) {
        long fid= 0;
       
      try{
        
        Optional<Recipe> recipe = recipeRespository.findById(Long.valueOf(body.get("Recipe").toString()));
        foodprop.setRecipe(recipe.get());
        foodprop.setFoodproperties(body.get("prop").toString());
        foodpropRepo.save(foodprop);
        Foodproperties foodtemp = foodpropRepo.findByRecipe_id(Long.valueOf(body.get("Recipe").toString())).get();
        fid = foodtemp.getId();
       

        Nutrivalue.setRecipe(recipe.get());
        Nutrivalue.setAmount(Float.parseFloat(body.get("amount").toString()));
        Nutrivalue.setEnergy(Float.parseFloat(body.get("energy").toString()));
        Nutrivalue.setFat(Float.parseFloat(body.get("fat").toString()));
        Nutrivalue.setSaturates(Float.parseFloat(body.get("saturates").toString()));
        Nutrivalue.setSodium(Float.parseFloat(body.get("sodium").toString()));
        Nutrivalue.setSugar(Float.parseFloat(body.get("sugar").toString()));
        NutriRepo.save(Nutrivalue);
        return true;
    }catch (Exception e) {

    if(fid !=0)
        foodpropRepo.deleteById(fid);
        return false;
 
}
       

    }



}