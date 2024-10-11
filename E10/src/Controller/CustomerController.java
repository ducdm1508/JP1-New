package Controller;

import Entity.Customer;
import Service.CustomerService;
import Exception.NotFoundCustomerIdException;

public class CustomerController {

    private CustomerService cs;

    public CustomerController(CustomerService cs) {
        this.cs = cs;
    }

    public Customer getCusById(int id) throws NotFoundCustomerIdException {
           try {
               return cs.getCusById(id);
           }catch (NotFoundCustomerIdException e) {
               throw new NotFoundCustomerIdException(e.getMessage());
           }
    }
}
