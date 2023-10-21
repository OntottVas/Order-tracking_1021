package hu.progmatic.ordertracking_1021.service;

import hu.progmatic.ordertracking_1021.model.Store;
import hu.progmatic.ordertracking_1021.repository.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class StoreService {
    private StoreRepository storeRepository;

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    public Store getStoreById(Long id) {
        return storeRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("There is no store under " + id + " id."));
    }


}
