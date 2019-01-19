package team20.se61.sut.wongnai.Repository;
import team20.se61.sut.wongnai.Entity.BusinessType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
    public interface BusinessTypeRepository extends JpaRepository<BusinessType, Long> {
}