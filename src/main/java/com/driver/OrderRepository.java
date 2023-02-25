package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class OrderRepository {
    private HashMap<String, Order> orderMap;
    private HashMap<String, DeliveryPartner> deliveryPartnerMap;
    private HashMap<String, List<Order>> orderDeliveryPartnerMap;

    private HashMap<String, List<String>> deliveryPartnerWithOrder;

    public OrderRepository(HashMap<String, Order> orderMap, HashMap<String, DeliveryPartner> deliveryPartnerMap, HashMap<String, List<Order>> orderDeliveryPartnerMap, HashMap<String, List<String>> deliveryPartnerWithOrder) {
        orderMap = new HashMap<>();
        deliveryPartnerMap = new HashMap<>();
        orderDeliveryPartnerMap = new HashMap<>();
        deliveryPartnerWithOrder = new HashMap<>();
    }

    // 1
    public void addOrder(Order order){
        orderMap.put(order.getId(), order);
    }

    // 2
//    public void addDeliveryPartner(String partnerId){
//        deliveryPartnerMap.put(partnerId, DeliveryPartner(partnerId));
//    }

    // 3
//    public void pairOrderAndDeliveryPartner(String orederId, String deliveryId){
//        List<Order> list = list.add(orderMap.get(orederId));
//
//        orderDeliveryPartnerMap.put(deliveryId, )
//    }

    // 4
    public Order findOrder(String orederId){
        return orderMap.get(orederId);
    }

    // 5
    public DeliveryPartner findPartner(String partnerId){
        return deliveryPartnerMap.get(partnerId);
    }

    //8
    public List<String> getALlOrders(){
        return new ArrayList<>(orderMap.keySet());
    }

    //9



}
