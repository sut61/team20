package team20.se61.sut.wongnai.Controller;

import team20.se61.sut.wongnai.Entity.*;
import team20.se61.sut.wongnai.Repository.*;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/MainIngraed")
class MainIngraedintsController{
    private  MainIngredRespository mainIngredRespository;
	

    public  MainIngraedintsController(MainIngredRespository mainIngredRespository){
        this.mainIngredRespository=mainIngredRespository;

    }

    @GetMapping()
    public Collection<MainIngredients> mainIngredients(){
        return mainIngredRespository.findAll().stream().collect(Collectors.toList());
    
    }


}

