package team20.se61.sut.wongnai.Repository;

import  team20.se61.sut.wongnai.Entity.PrefixEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface PrefixRepository extends JpaRepository<PrefixEntity, Long> {
    PrefixEntity findByPrefix(String prefix);

}