package Code.Functions;

import Code.Customer.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    private List<Customer> customers;

    public CustomerController() {
        this.customers = new ArrayList<>();
        // Initialize customers from data source if needed
    }

    public Customer getCustomerById(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null; // Customer not found
    }
}