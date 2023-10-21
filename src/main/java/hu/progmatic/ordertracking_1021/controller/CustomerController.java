package hu.progmatic.ordertracking_1021.controller;

import hu.progmatic.ordertracking_1021.model.Customer;
import hu.progmatic.ordertracking_1021.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @GetMapping("/customers")
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customer/customers";
    }

    @GetMapping("/addCustomer")
    public String addCustomer(Model model) {
        model.addAttribute("newCustomer", new Customer());
        return "customer/addCustomer";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute("newCustomer") Customer newCustomer) {
        customerService.addNewCustomer(newCustomer);
        return "redirect:/customers";
    }

    @GetMapping("/modifyName")
    public String modifyName() {
        return "customer/modifyName";
    }

    @PostMapping("/modifyName")
    public String modifyName(@RequestParam("id") Long id,
                             @RequestParam("name") String newName) {
        customerService.modifyName(id, newName);
        return "redirect:/customers";
    }

    @GetMapping("/modifyEmail")
    public String modifyEmail() {
        return "customer/modifyEmail";
    }

    @PostMapping("/modifyEmail")
    public String modifyEmail(@RequestParam("id") Long id,
                              @RequestParam("email") String newEmail) {
        customerService.modifyEmail(id, newEmail);
        return "redirect:/customers";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer() {
        return "customer/deleteCustomer";
    }

    @PostMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("id") Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }
}
