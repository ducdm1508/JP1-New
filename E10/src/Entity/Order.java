package Entity;

import java.time.LocalDate;

public class Order {
    private String id;
    private Customer customer;
    private LocalDate datetime;

    public Order() {;}
    public Order(String id, Customer customer, LocalDate datetime) {
        this.id = id;
        this.customer = customer;
        this.datetime = datetime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDate datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", datetime=" + datetime +
                '}';
    }
}
