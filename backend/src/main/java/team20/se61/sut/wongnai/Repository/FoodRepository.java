package team20.se61.sut.wongnai.Repository;

import team20.se61.sut.wongnai.Entity.Food;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface FoodRepository extends JpaRepository<Food, Long> {

    Collection<Food> findByStoreId(Long storeId);
}