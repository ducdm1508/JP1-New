package Service;

import Entity.Customer;
import Global.Global;
import IGeneric.IGeneral;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CustomerService implements IGeneral<Customer> {

    private List<Customer> customers;
    public CustomerService(List<Customer> customers){
        this.customers = customers;
    }

    @Override
    public List<Customer> update(Customer customer) {
        customers.removeIf(cus-> cus.getId() == customer.getId());
        customers.add(customer);
        return new ArrayList<>(customers);
    }

    @Override
    public List<Customer> sort() {
        return customers.stream()
                .sorted(Comparator.comparing(Customer::getDiscount))
                .toList();
    }

    @Override
    public Customer getById(int id) {
        Optional<Customer> findCus = customers.stream()
                .filter(cus -> cus.getId() == id)
                .findFirst();
        if(findCus.isPresent()){
            return findCus.get();
        }else {
            return null;
        }
    }

    @Override
    public List<Customer> getByName(String keyword) {
        List<Customer> findCus = customers.stream()
                .filter(cus -> Global.ignoreCase(cus.getName(), keyword))
                .toList();
        if (findCus.size()>0){
            return findCus;
        }else {
            return null;
        }
    }
}
