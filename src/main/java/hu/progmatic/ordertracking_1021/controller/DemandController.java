package hu.progmatic.ordertracking_1021.controller;

import hu.progmatic.ordertracking_1021.model.Demand;
import hu.progmatic.ordertracking_1021.service.DemandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class DemandController {
    private DemandService demandService;

    @GetMapping("/demands")
    public String getDemands(Model model) {
        model.addAttribute("demands", demandService.getAllDemands());
        return "demand/demands";
    }

    @GetMapping("/addDemand")
    public String addDemand(Model model) {
        model.addAttribute("newDemand", new Demand());
        return "demand/addDemand";
    }

    @PostMapping("/addDemand")
    public String addDemand(@ModelAttribute("newDemand") Demand newDemand) {
        demandService.addNewDemand(newDemand);
        return "redirect:/demands";
    }

    @GetMapping("/deleteDemand")
    public String deleteDemand() {
        return "demand/deleteDemand";
    }

    @PostMapping("/deleteDemand")
    public String deleteDemand(@RequestParam("id") Long id) {
        demandService.deleteDemand(id);
        return "redirect:/demands";
    }
}
