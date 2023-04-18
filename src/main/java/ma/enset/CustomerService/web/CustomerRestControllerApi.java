package ma.enset.CustomerService.web;

import jakarta.persistence.Id;
import jakarta.ws.rs.Path;
import ma.enset.CustomerService.entity.Customer;
import ma.enset.CustomerService.repository.Customerrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestControllerApi {
    @Autowired
    private Customerrepository customerrepository;
    @GetMapping("/customers/{id}")
    private Optional<Customer> getCustomer(@PathVariable long id){
        return Optional.of(customerrepository.findById(id).get());
    }
    @GetMapping("/customers")
    private List<Customer> getAllCustomers(){
        return customerrepository.findAll();
    }
    @PostMapping("/customers")
    private Customer addCustomer(@RequestBody Customer customer){
        return customerrepository.save(customer);
    }
    @PutMapping("/customers/{id}")
    private Customer updateCustomer(@RequestBody Customer customer,@PathVariable long id){
        return customerrepository.findById(id)
                .map(c->{
                    c.setName(customer.getName());
                    c.setEmail(customer.getEmail());
                    return customerrepository.save(c);
                })
                .orElseThrow(()->new IllegalArgumentException("Invalid Id"+id));
    }
    @DeleteMapping("/customers/{id}")
    private void deleteCustomer(@PathVariable long id){
        customerrepository.deleteById(id);
    }

}