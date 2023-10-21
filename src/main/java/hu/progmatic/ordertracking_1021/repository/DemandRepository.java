package hu.progmatic.ordertracking_1021.repository;

import hu.progmatic.ordertracking_1021.model.Demand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandRepository extends JpaRepository<Demand, Long> {

    void deleteDemandsByCustomerId(Long customerId);
}
