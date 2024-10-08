package Entity;

import Controller.CustomerController;

public class Account {
    private int id;
    private Customer customer;

    private double balance;

    public Account(){;}
    public Account(int id, Customer customer, double balance) {
        this.id = id;
        this.customer = customer;
        this.balance = balance;
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

    public String getCusName(){
        return customer.getName();
    }

    public double getCusDiscount(){
        return customer.getDiscount();
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.setBalance(this.getBalance() + amount);
    }

    public void withdraw(double amount) {
        if (this.getBalance() < amount) {
            this.setBalance(this.getBalance() - amount);
        }else {
            System.out.println("Amount withdrawn exceeds the current balance!");
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", customer=" + customer +
                ", balance=" + balance +
                '}';
    }
}
