package com.rollingstone.controller;



import com.rollingstone.events.CustomerEvent;
import com.rollingstone.model.Customer;
import com.rollingstone.services.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/customer-service")
public class CustomerController extends AbstractController {


    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /*---Add new Customer---*/
    @PostMapping("/customer")
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.save(customer);
        CustomerEvent customerCreatedEvent = new CustomerEvent(this, "CustomerCreatedEvent", savedCustomer);
        eventPublisher.publishEvent(customerCreatedEvent);
        return ResponseEntity.ok().body("New Customer has been saved with ID:" + savedCustomer.getCustomerId());
    }

    /*---Get a Customer by id---*/
    @GetMapping("/customer/{id}")
    @ResponseBody
    public Customer getCustomer(@PathVariable("id") long id) {
        Optional<Customer> returnedOrder = customerService.get(id);
        Customer customer = returnedOrder.get();

        CustomerEvent customerCreatedEvent = new CustomerEvent(this, "CustomerRetrievedEvent",
                customer);
        eventPublisher.publishEvent(customerCreatedEvent);
        return customer;
    }


    /*---get all Customer---*/
    @GetMapping("/customer")
    public @ResponseBody Page<Customer> getCustomersByPage(
            @RequestParam(value = "pagenumber", required = true, defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "pagesize", required = true, defaultValue = "20") Integer pageSize) {
        Page<Customer> pagedCustomers = customerService.getCustomersByPage(pageNumber, pageSize);
        return pagedCustomers;
    }

    @GetMapping("/customer/all")
    public @ResponseBody List<Customer> getAllCustomers() {
        List<Customer> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    /*---Update a Customer by id---*/
    @PutMapping("/customer/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
        checkResourceFound(this.customerService.get(id));
        customerService.update(id, customer);
        return ResponseEntity.ok().body("Customer has been updated successfully.");
    }

    /*---Delete a Customer by id---*/
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") long id) {
        checkResourceFound(this.customerService.get(id));
        customerService.delete(id);
        return ResponseEntity.ok().body("Customer has been deleted successfully.");
    }
}