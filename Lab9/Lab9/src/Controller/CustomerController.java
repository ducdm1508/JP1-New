package Controller;

import Entity.Customer;
import Service.CustomerService;

import java.util.List;

public class CustomerController {

    private CustomerService cs;

    public CustomerController(CustomerService cs){
        this.cs = cs;
    }

    public List<Customer> update(Customer customer){
        return cs.update(customer);
    }

    public List<Customer> sort(){
        return cs.sort();
    }

    public Customer getById(int id){
        Customer findId = cs.getById(id);
        if (findId != null){
            return findId;
        }else {
            return null;
        }
    }

    public List<Customer> getByName(String name){
        List<Customer> findName = cs.getByName(name);
        if (findName != null){
            return findName;
        }else {
            return null;
        }
    }
}
