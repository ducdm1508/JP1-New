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

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Customer> customers = new ArrayList<>();
        List<Account> accounts = new ArrayList<>();
        List<Invoice> invoices = new ArrayList<>();

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
        accounts.add(new Account(2, customers.get(3), 3000));
        accounts.add(new Account(3, customers.get(2), 4300));
        accounts.add(new Account(4, customers.get(1), 6200));

        invoices.add(new Invoice(1, customers.get(0), 4000, LocalDate.of(2024, 7, 12)));
        invoices.add(new Invoice(2, customers.get(3), 2000, LocalDate.of(2024, 1, 15)));
        invoices.add(new Invoice(3, customers.get(2), 3000, LocalDate.of(2024, 9, 10)));
        invoices.add(new Invoice(4, customers.get(1), 4500, LocalDate.of(2024, 8, 12)));

        boolean exit = false;
        while (!exit) {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Hiển thị danh sách khách hàng theo tên");
            System.out.println("2. Tìm tài khoản theo ID");
            System.out.println("3. Tìm tài khoản theo tên khách hàng");
            System.out.println("4. Tìm hoá đơn theo ID");
            System.out.println("5. Tìm hoá đơn theo tên khách hàng");
            System.out.println("6. Áp dụng giảm giá cho hoá đơn nữ tháng 8");
            System.out.println("7. Thanh toán hoá đơn");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    ct.sortedCustomerByName().forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("Nhập Account ID: ");
                    int accountId = sc.nextInt();
                    Account foundAccById = at.getAccById(accountId);
                    if (foundAccById != null) {
                        System.out.println(foundAccById);
                    } else {
                        System.out.println("Không tìm thấy tài khoản.");
                    }
                    break;

                case 3:
                    System.out.print("Nhập tên khách hàng: ");
                    String accountName = sc.nextLine();
                    List<Account> getAccByNames = at.getAccByCusName(accountName);
                    if (getAccByNames == null || getAccByNames.isEmpty()) {
                        System.out.println("Không tìm thấy tài khoản.");
                    } else {
                        System.out.println(getAccByNames);
                    }
                    break;

                case 4:
                    System.out.print("Nhập Invoice ID: ");
                    int invId = sc.nextInt();
                    Invoice foundInvById = it.getInvoiceById(invId);
                    if (foundInvById != null) {
                        System.out.println(foundInvById);
                    } else {
                        System.out.println("Không tìm thấy hoá đơn.");
                    }
                    break;

                case 5:
                    System.out.print("Nhập tên khách hàng: ");
                    String invName = sc.nextLine();
                    List<Invoice> getInvByNames = it.getInvoicesByName(invName);
                    if (getInvByNames == null) {
                        System.out.println("Không tìm thấy hoá đơn.");
                    } else {
                        System.out.println(getInvByNames);
                    }
                    break;

                case 6:
                    List<Invoice> discounted = it.applyDiscountForFemaleAugustInvoices();
                    if (discounted == null || discounted.isEmpty()) {
                        System.out.println("Không tìm thấy hoá đơn đủ điều kiện giảm giá.");
                    } else {
                        System.out.println(discounted);
                    }
                    break;

                case 7:
                    System.out.print("Nhập Account ID: ");
                    int accIdForPay = sc.nextInt();
                    Account accForPay = at.getAccById(accIdForPay);
                    System.out.println("Thanh toán");
                    Invoice payInvoice = it.payBill(accForPay);
                    if (payInvoice != null) {
                        System.out.println("Thanh toán thành công hoá đơn: " + payInvoice);
                        System.out.println(accForPay);
                    } else {
                        System.out.println("Không đủ tiền thanh toán.");
                    }
                    break;

                case 0:
                    exit = true;
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }

        sc.close();
    }
}
