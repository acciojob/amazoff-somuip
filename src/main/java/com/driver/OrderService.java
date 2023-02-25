package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    //1
    public void addOrder(Order order){
        orderRepository.addOrder(order);
    }

    //2
    public void addPartner(String partnerId){
        orderRepository.addDeliveryPartner(partnerId);
    }

    //4
    public Order findOrder(String orderId){
        return orderRepository.findOrder(orderId);
    }

    //5
    public DeliveryPartner findPartner(String partnerId){
        return orderRepository.findPartner(partnerId);
    }

}
