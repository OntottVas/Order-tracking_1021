package hu.progmatic.ordertracking_1021.service;

import hu.progmatic.ordertracking_1021.model.Customer;
import hu.progmatic.ordertracking_1021.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("There is no customer under " + id + " id."));
    }

    public void addNewCustomer(Customer newCustomer) {
        customerRepository.save(newCustomer);
    }

    public void modifyName(Long id, String newName) {
        Customer customer = getCustomerById(id);
        customer.setName(newName);
        customerRepository.save(customer);
    }

    public void modifyEmail(Long id, String newEmail) {
        Customer customer = getCustomerById(id);
        customer.setEmail(newEmail);
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
