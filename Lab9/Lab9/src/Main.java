import Controller.AccountController;
import Controller.CustomerController;
import Controller.InvoiceController;
import Entity.Account;
import Entity.Customer;
import Entity.Gender;
import Entity.Invoice;
import Service.AccountService;
import Service.CustomerService;
import Service.InvoiceService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Customer> customers = new ArrayList<>();
        List<Account> accounts = new ArrayList<>();
        List<Invoice> invoices = new ArrayList<>();

        CustomerService cs = new CustomerService(customers);
        CustomerController ct = new CustomerController(cs);

        AccountService as = new AccountService(accounts);
        AccountController at = new AccountController(as);

        InvoiceService is = new InvoiceService(invoices);
        InvoiceController it = new InvoiceController(is);

        customers.add(new Customer(1, "Trung", Gender.M, 10));
        customers.add(new Customer(2, "Linh", Gender.F, 21));
        customers.add(new Customer(3, "Hai", Gender.F, 13));
        customers.add(new Customer(4, "Hung", Gender.M, 12));

        accounts.add(new Account(1, customers.get(0), 2000));
        accounts.add(new Account(2, customers.get(1), 3000));
        accounts.add(new Account(3, customers.get(2), 4300));
        accounts.add(new Account(4, customers.get(3), 6200));

        invoices.add(new Invoice(1, customers.get(0), 4000, LocalDate.of(2024, 7, 12)));
        invoices.add(new Invoice(2, customers.get(1), 2000, LocalDate.of(2024, 1, 15)));
        invoices.add(new Invoice(3, customers.get(2), 3000, LocalDate.of(2024, 9, 10)));
        invoices.add(new Invoice(4, customers.get(3), 4500, LocalDate.of(2024, 9, 12)));

        int choice = -1;

        while (choice != 0) {
            System.out.println("0 - Exit");
            System.out.println("1 - List sort");
            System.out.println("2 - Search");
            System.out.println("3 - Display discount in month 8");
            System.out.println("4 - Display account cannot pay");
            System.out.println("5 - Display invoice can pay");
            System.out.println("6 - Update customer");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Out");
                    break;
                case 1:
                    System.out.println("List Customer sort");
                    ct.sort().forEach(System.out::println);
                    System.out.println("List Account sort");
                    at.sort().forEach(System.out::println);
                    System.out.println("List Invoice sort");
                    it.sort().forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("1 - Search customer");
                    System.out.println("2 - Search account");
                    System.out.println("3 - Search invoice");
                    System.out.print("Enter your choice: ");
                    int searchChoice = sc.nextInt();

                    switch (searchChoice) {
                        case 1:
                            System.out.print("Enter Customer Id: ");
                            int cusId = sc.nextInt();
                            Customer findId = ct.getById(cusId);
                            if (findId != null) {
                                System.out.println(findId);
                            } else {
                                System.out.println("Not found");
                            }

                            System.out.print("Enter Customer Name: ");
                            sc.nextLine();
                            String cusName = sc.nextLine();
                            List<Customer> findName = ct.getByName(cusName);
                            if (findName != null) {
                                System.out.println(findName);
                            } else {
                                System.out.println("Not found");
                            }
                            break;

                        case 2:
                            System.out.print("\nInput Account ID: ");
                            int accountId = sc.nextInt();
                            Account foundAccById = at.getById(accountId);
                            if (foundAccById != null) {
                                System.out.println(foundAccById);
                            } else {
                                System.out.println("Account not found");
                            }

                            sc.nextLine();
                            System.out.print("\nInput Account Name: ");
                            String accountName = sc.nextLine();
                            List<Account> getAccByNames = at.getByName(accountName);
                            if (getAccByNames == null) {
                                System.out.println("Account not found");
                            } else {
                                System.out.println(getAccByNames);
                            }
                            break;

                        case 3:
                            System.out.print("\nInput Invoice ID: ");
                            int invId = sc.nextInt();
                            Invoice foundInvById = it.getById(invId);
                            if (foundInvById != null) {
                                System.out.println(foundInvById);
                            } else {
                                System.out.println("Invoice not found");
                            }

                            sc.nextLine();
                            System.out.print("\nInput Invoice Name: ");
                            String invName = sc.nextLine();
                            List<Invoice> getInvByNames = it.getByName(invName);
                            if (getInvByNames == null) {
                                System.out.println("Invoice not found");
                            } else {
                                System.out.println(getInvByNames);
                            }
                            break;
                    }
                    break;
                case 3:
                    List<Invoice> discounted = it.applyDiscountForFemaleAugustInvoices();
                    discounted.forEach(System.out::println);
                    break;
                case 4:
                    List<Invoice> listCanNotPay = it.getCusCanNotPay(accounts);
                    if (listCanNotPay != null) {
                        listCanNotPay.forEach(System.out::println);
                    } else {
                        System.out.println("No list");
                    }
                    break;
                case 5:
                    List<Invoice> listCanPay = it.getCusCanPay(accounts);
                    if (listCanPay != null) {
                        listCanPay.forEach(System.out::println);
                    } else {
                        System.out.println("No list");
                    }
                    break;
                case 6:
                    Customer updatedCustomer = new Customer(1, "Tuan", Gender.M, 10);
                    System.out.println(updatedCustomer);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}
