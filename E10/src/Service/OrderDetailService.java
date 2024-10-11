package Service;

import Entity.OrderDetail;

import java.util.List;

import Exception.NotEnoughInventoryNumberException;

public class OrderDetailService {

    public List<OrderDetail> orderDetails;

    public OrderDetailService(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<OrderDetail> placeOrder(OrderDetail orderDetail) throws NotEnoughInventoryNumberException {

        if (orderDetail.getQuantity() > orderDetail.getProduct().getQuantity()){
            throw new NotEnoughInventoryNumberException("Not enough inventory:" + orderDetail.getProduct().getName());
        }

        orderDetails.add(orderDetail);
        return orderDetails;
    }
}
