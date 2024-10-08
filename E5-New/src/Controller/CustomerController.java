package Controller;

import Entity.Customer;
import Service.CustomerSevice;

import java.util.Comparator;
import java.util.List;

public class CustomerController {

    private static List<Customer> customers;
    private CustomerSevice cs;

    public CustomerController(CustomerSevice cs) {
        this.cs = cs;
        this.customers = cs.getCustomers();
    }

    public static List<Customer> sortedCustomerByName(){
         return customers.stream()
                .sorted(Comparator.comparing(Customer::getName))
                .toList();
    }
}
