package Service;

import Entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerSevice {

    private Customer customer;
    List<Customer> customers;

    public CustomerSevice(List<Customer> customers) {
        this.customers = customers;
    }

    public Customer getCustomer(){
        return customer;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

}
