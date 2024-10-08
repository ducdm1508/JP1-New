package Entity;

import java.time.LocalDate;

public class Invoice {
    private int id;
    private Customer customer;
    private double amount;
    private LocalDate datetime;

    public Invoice(){;}
    public Invoice(int id, Customer customer, double amount, LocalDate datetime) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
        this.datetime = datetime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDate datetime) {
        this.datetime = datetime;
    }

    public int getCusId(){
        return customer.getId();
    }

    public String getCusName(){
        return customer.getName();
    }

    public double getCusDiscount(){
        return customer.getDiscount();
    }

    public double getAmountAfterDiscount(){
        return amount * (1- this.getCusDiscount()/100);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", customer=" + customer +
                ", amount=" + amount +
                ", datetime=" + datetime +
                '}';
    }
}
