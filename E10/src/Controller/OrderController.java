package Controller;

import Entity.Order;
import Service.OrderService;

import Exception.InvalidOrderIdException;

import java.util.List;

public class OrderController {

    private OrderService os;
    public OrderController(OrderService os) {
        this.os = os;
    }

    public List<Order> createOrder(Order order) {
        try {
            List<Order> result = os.createOder(order);
            System.out.println("Order created successfully");
            return result;
        }catch (InvalidOrderIdException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
