package ie.atu.customermanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    public Optional<Customer> getCustomerById(String customerId){
        return customerRepository.findById(customerId);
    }

    public Customer updateCustomer(String customerId, Customer updatedCustomer){
        return customerRepository.findById(customerId).map(customer -> {
            customer.setFirstName(updatedCustomer.getFirstName());
            customer.setLastName(updatedCustomer.getLastName());
            customer.setCustomerId(updatedCustomer.getCustomerId());
            customer.setEmail(updatedCustomer.getEmail());
            customer.setEircode(updatedCustomer.getEircode());
            customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
            return  customerRepository.save(customer);
        }).orElse(null);

    }
    public void deleteCustomerById(String customerId){
        customerRepository.deleteById(customerId);
    }
}
