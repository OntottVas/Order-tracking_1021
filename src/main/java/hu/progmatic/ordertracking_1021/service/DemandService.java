package hu.progmatic.ordertracking_1021.service;

import hu.progmatic.ordertracking_1021.model.Demand;
import hu.progmatic.ordertracking_1021.repository.DemandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class DemandService {
    private DemandRepository demandRepository;

    public List<Demand> getAllDemands() {
        return demandRepository.findAll();
    }

    public Demand getDemandById(Long id) {
        return demandRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("There is no demand with " + id + " id."));
    }

    public void addNewDemand(Demand newDemand) {
        demandRepository.save(newDemand);
    }

    public void deleteDemand(Long id) {
        demandRepository.deleteById(id);
    }
}
