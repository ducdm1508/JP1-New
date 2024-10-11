package Service;

import Entity.Customer;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import Exception.NotFoundCustomerIdException;
import Global.CustomerValidation;

public class CustomerService {

    private List<Customer> customers;

    public CustomerService(List<Customer> customers) {
        this.customers = customers;
    }


    public Customer getCusById(int id) throws NotFoundCustomerIdException {
        Optional<Customer> customer = customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
        if (customer.isPresent()) {
            return customer.get();
        } else {
            throw new NotFoundCustomerIdException("Not found: " + id);
        }
    }

}
