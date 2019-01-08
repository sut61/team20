package team20.se61.sut.wongnai.Repository;
import team20.se61.sut.wongnai.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
    public interface RoomRepository extends JpaRepository<Room, Long> {
}