import Controller.AccountController;
import Controller.CustomerController;
import Controller.InvoiceController;
import Entity.Account;
import Entity.Customer;
import Entity.Gender;
import Entity.Invoice;
import Service.AccountService;
import Service.CustomerSevice;
import Service.InvoiceService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Customer> customers = new ArrayList<Customer>();
        List<Account> accounts = new ArrayList<Account>();
        List<Invoice> invoices = new ArrayList<Invoice>();

        CustomerSevice cs = new CustomerSevice(customers);
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

        ct.sortedCustomerByName().forEach(System.out::println);

        System.out.print("\nInput Account ID : ");
        int accountId = sc.nextInt();
        Account foundAccById = at.getAccById(accountId);
        if (foundAccById != null) {
            System.out.println(foundAccById);
        } else {
            System.out.println("Account not found");
        }

        sc.nextLine();
        System.out.print("\nInput Account Name : ");
        String accountName = sc.nextLine();
        List<Account> getAccByNames = at.getAccByCusName(accountName);
        if (getAccByNames == null) {
            System.out.println("Account not found");
        } else {
            System.out.println(getAccByNames);
        }

        System.out.print("\nInput Invoice ID : ");
        int invId = sc.nextInt();
        Invoice foundInvById = it.getInvoiceById(invId);
        if (foundInvById != null) {
            System.out.println(foundInvById);
        } else {
            System.out.println("Invoice not found");
        }

        sc.nextLine();
        System.out.print("\nInput Invoice Name : ");
        String invName = sc.nextLine();
        List<Invoice> getInvByNames = it.getInvoicesByName(invName);
        if (getInvByNames == null) {
            System.out.println("Invoice not found");
        } else {
            System.out.println(getInvByNames);
        }

        List<Invoice> discounted = it.applyDiscountForFemaleAugustInvoices();
        if (discounted == null) {
            System.out.println("Invoice not found");
        }else {
            System.out.println(discounted);
        }

        List<Invoice> listCanNotPay = it.getCusCanNotPay(accounts);
        if (listCanNotPay != null) {
            listCanNotPay.forEach(System.out::println);
        }else {
            System.out.println("No list");
        }

        List<Invoice> listCanPay = it.getCusCanPay(accounts);
        if (listCanPay != null) {
            listCanPay.forEach(System.out::println);
        }else {
            System.out.println("No list");
        }
    }
}