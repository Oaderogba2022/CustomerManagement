package ie.atu.customermanagement;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer){
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }

    @GetMapping
    public List<Customer>getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Optional<Customer>> getCustomersById(@PathVariable String customerId){
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String customerId, @Valid @RequestBody Customer updatedCustomer){
        Customer updated = customerService.updateCustomer(customerId,updatedCustomer);
        return updated != null? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String customerId){
        customerService.deleteCustomerById(customerId);
        return ResponseEntity.noContent().build();
    }

}
