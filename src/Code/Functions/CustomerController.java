package Code.Functions;

import Code.Customer.*;
import java.util.HashSet;
import java.util.Set;

public class CustomerController {
    private Set<Customer> customers;

    public CustomerController() {
        this.customers = new HashSet<>();
        // Initialize customers from data source if needed
    }

    public Customer getCustomerById(String customerName) {
        for (Customer customer : customers) {
            if (customer.getCustomerName().equals(customerName)) {
                return customer;
            }
        }
        return null; // Customer not found
    }

    public Set<Customer> getAllCustomers() {
        return customers;
    }
}