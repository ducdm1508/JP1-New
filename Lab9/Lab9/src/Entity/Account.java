package Entity;

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

    public double getBlance() {
        return balance;
    }

    public void setBlance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCusName(){
        return customer.getName();
    }

    public void deposit(double amount){
         this.balance += amount;
    }

    public void withdraw(double amount){
        if (balance >= amount){
            this.balance -= amount;
        }else {
            System.out.println("Amount withdraw exceeds the current blance");
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
