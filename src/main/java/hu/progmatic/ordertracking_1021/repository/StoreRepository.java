package hu.progmatic.ordertracking_1021.repository;

import hu.progmatic.ordertracking_1021.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
