package hu.progmatic.ordertracking_1021.controller;

import hu.progmatic.ordertracking_1021.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class StoreController {
    private StoreService storeService;

    @GetMapping("/stores")
    public String getAllStores(Model model) {
        model.addAttribute("stores", storeService.getAllStores());
        return "store/stores";
    }
}
