package hu.progmatic.ordertracking_1021.repository;

import hu.progmatic.ordertracking_1021.model.Demand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandRepository extends JpaRepository<Demand, Long> {

    void deleteDemandsByCustomerId(Long customerId);

    @Query(nativeQuery = true, value = "SELECT name FROM customer c " +
            "JOIN demand d ON c.id = d.customer_id " +
            "GROUP BY name " +
            "ORDER BY SUM(cost) LIMIT 1")
    String findBiggestSpender();
}
