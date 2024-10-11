import Controller.CustomerController;
import Controller.OrderController;
import Controller.OrderDetailController;
import Controller.ProductController;
import Entity.*;
import Service.CustomerService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Exception.NotFoundCustomerIdException;
import Exception.InvalidProducIdException;
import Exception.NotFoundProductIdException;
import Exception.InvalidQuantityException;
import Exception.InvalidOrderIdException;
import Exception.NotEnoughInventoryNumberException;

import Service.OrderDetailService;
import Service.OrderService;
import Service.ProductService;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<Customer>();
        List<Product> products = new ArrayList<Product>();
        List<Order> orders = new ArrayList<Order>();
        List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

        ProductService ps = new ProductService(products);
        ProductController pt = new ProductController(ps);

        CustomerService cs = new CustomerService(customers);
        CustomerController ct = new CustomerController(cs);

        OrderService os = new OrderService(orders);
        OrderController ot = new OrderController(os);

        OrderDetailService ods = new OrderDetailService(orderDetails);
        OrderDetailController odt = new OrderDetailController(ods);

        customers.add(new Customer(1,"tuan"));
        customers.add(new Customer(2,"tu"));

        try {
            pt.createProduct(new Product("MS123456", "Iphone", 30));
            pt.createProduct(new Product("MS123453", "Samsung", 40));
            pt.createProduct(new Product("MS123454", "Sonny", 50));
            pt.createProduct(new Product("MA123455", "LG", 60));
            pt.createProduct(new Product("MS123456", "Xiaomi", 70));
        } catch (InvalidProducIdException e) {
            System.out.println(e.getMessage());
        } catch (InvalidQuantityException e) {
            System.out.println(e.getMessage());
        }

        try {
            ot.createOrder(new Order("ORDPM12345679", customers.get(0), LocalDate.now()));
            ot.createOrder(new Order("ORDPM12345678", customers.get(1), LocalDate.now()));
        }catch (InvalidOrderIdException e){
            System.out.println(e.getMessage());
        }

        try {
            odt.placeOrder(new OrderDetail(1, orders.get(0), products.get(0), 20, Status.P));
        }catch (NotEnoughInventoryNumberException e){
            System.out.println(e.getMessage());
        }

        products.forEach(System.out::println);
        orders.forEach(System.out::println);
        orderDetails.forEach(System.out::println);

        try {
            Customer customer = ct.getCusById(7);
            System.out.println(customer);
        } catch (NotFoundCustomerIdException e) {
            System.out.println(e.getMessage());
        }

        try {
            Product findProId = ps.getProductById("MS123490");
            System.out.println(findProId);
        } catch (NotFoundProductIdException e) {
            System.out.println(e.getMessage());
        }




    }
}