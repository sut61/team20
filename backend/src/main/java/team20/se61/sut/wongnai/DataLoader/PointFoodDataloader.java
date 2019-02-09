package team20.se61.sut.wongnai.DataLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import team20.se61.sut.wongnai.Entity.PointFoodEntity;
import team20.se61.sut.wongnai.Repository.PointFoodRepository;

@Component
public class PointFoodDataloader implements ApplicationRunner {
    @Autowired
    PointFoodRepository pointFoodRepository;
    @Override

    public void run(ApplicationArguments args) throws Exception {

        pointFoodRepository.save(new PointFoodEntity(0));
        pointFoodRepository.save(new PointFoodEntity(1));
        pointFoodRepository.save(new PointFoodEntity(2));
        pointFoodRepository.save(new PointFoodEntity(3));
        pointFoodRepository.save(new PointFoodEntity(4));
        pointFoodRepository.save(new PointFoodEntity(5));

        pointFoodRepository.findAll().forEach(System.out::println);
    }
}
