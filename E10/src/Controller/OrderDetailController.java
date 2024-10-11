package Controller;

import Entity.OrderDetail;
import Service.OrderDetailService;

import java.util.ArrayList;
import java.util.List;
import Exception.NotEnoughInventoryNumberException;

public class OrderDetailController {

    private OrderDetailService ods;
    public OrderDetailController(OrderDetailService ods) {
        this.ods = ods;
    }

    public List<OrderDetail> placeOrder(OrderDetail orderDetail) throws NotEnoughInventoryNumberException {
        try {
            List<OrderDetail> orderDetails = ods.placeOrder(orderDetail);
            System.out.println("OrderDetail created successfully");
            return orderDetails;
        }catch (NotEnoughInventoryNumberException e){
            System.out.println("Not enough inventory number");
            return null;
        }
    }


}
