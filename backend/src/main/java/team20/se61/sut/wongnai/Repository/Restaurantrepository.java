package team20.se61.sut.wongnai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team20.se61.sut.wongnai.Entity.Restaurant;

@Repository
public interface Restaurantrepository extends JpaRepository<Restaurant,Long> {
    Restaurant findByIdentity(String restaurant);
}
