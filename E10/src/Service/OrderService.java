package Service;

import Entity.Order;
import Global.Ordervalidation;

import Exception.InvalidOrderIdException;
import java.util.List;

public class OrderService {

    private List<Order> orders;
    public OrderService(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> createOder(Order order) throws InvalidOrderIdException {
        if(!Ordervalidation.validateOrderId(order.getId())) {
            throw new InvalidOrderIdException("Validate order ID: " + order.getId());
        }
        orders.add(order);
        return orders;
    }
}
