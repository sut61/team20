package team20.se61.sut.wongnai.DataLoader;

import team20.se61.sut.wongnai.Entity.*;
import team20.se61.sut.wongnai.Repository.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class RecipeDataloader implements ApplicationRunner {

    @Autowired  private CookingMethodRespository cookingMethodRespository;
    @Autowired  private FoodTypeRespository foodTypeRespository;
    @Autowired  private MainIngredRespository mainIngredRespository;
    @Autowired private RecipeRespository recipeRespository;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {

        cookingMethodRespository.save(new CookingMethod("ทอด"));
        cookingMethodRespository.save(new CookingMethod("ผัด"));
        cookingMethodRespository.save(new CookingMethod("แกง"));
        cookingMethodRespository.save(new CookingMethod("ต้ม"));
        cookingMethodRespository.save(new CookingMethod("ตุ๋น"));
        cookingMethodRespository.save(new CookingMethod("นึง"));
        cookingMethodRespository.save(new CookingMethod("ย่าง"));

        foodTypeRespository.save(new FoodType("คาว"));
        foodTypeRespository.save(new FoodType("หวาน"));
        foodTypeRespository.save(new FoodType("มังสาวิรัส"));
        foodTypeRespository.save(new FoodType("เจ"));

        mainIngredRespository.save(new MainIngredients("หมู"));
        mainIngredRespository.save(new MainIngredients("หมึก"));
        mainIngredRespository.save(new MainIngredients("กุ้ง"));
        mainIngredRespository.save(new MainIngredients("ไก่"));
        mainIngredRespository.save(new MainIngredients("ไข่"));
        mainIngredRespository.save(new MainIngredients("ปลา"));
        mainIngredRespository.save(new MainIngredients("เนื้อ"));
        mainIngredRespository.save(new MainIngredients("อืนๆ"));

       
        cookingMethodRespository.findAll().forEach(System.out::println);
        foodTypeRespository.findAll().forEach(System.out::println);
        mainIngredRespository.findAll().forEach(System.out::println);
       
	}
    
}