package team20.se61.sut.wongnai.Repository;

import team20.se61.sut.wongnai.Entity.Store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface StoreRepository extends JpaRepository<Store, Long> {}