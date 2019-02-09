package team20.se61.sut.wongnai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team20.se61.sut.wongnai.Entity.FoodForReviewEntity;
import team20.se61.sut.wongnai.Entity.PointFoodEntity;

@Repository
public interface  FoodForReviewRepository extends JpaRepository<FoodForReviewEntity,Long> {
}