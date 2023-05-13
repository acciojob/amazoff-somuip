package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepository {

    Map<String, Order> orderDb = new HashMap<>();

    Map<String, DeliveryPartner> partnerDb = new HashMap<>();

    Map<String, String> orderPartnerDb = new HashMap<String, String>();

    Map<DeliveryPartner, HashSet<Order>> partnerOrderListDb = new HashMap<>();



    public void addOrder(Order order){
        orderDb.put(order.getId(), order);
    }

    public void addPartner(String partnerId){
        partnerDb.put(partnerId, new DeliveryPartner(partnerId));
    }

    public Order getOrder(String orderId){
        return orderDb.get(orderId);
    }

    public void addOrderToPartner(String orderId, String partnerId){
        orderPartnerDb.put(orderId,partnerId);

        // increasing the no of orders of this partner
        DeliveryPartner partner = partnerDb.get(partnerId);
        partner.setNumberOfOrders(partner.getNumberOfOrders() + 1);
    }



    public DeliveryPartner getPartnerById(String partnerId){
        return partnerDb.get(partnerId);
    }

    public Integer getNumOfOrdersOfPartner(String partnerId){
        DeliveryPartner partner = partnerDb.get(partnerId);
        return partner.getNumberOfOrders();
    }


    public void addOrderPartnerPair(String orderId, String partnerId) {
        orderPartnerDb.put(orderId, partnerId);
        DeliveryPartner partner = partnerDb.get(partnerId);
        partner.setNumberOfOrders(partner.getNumberOfOrders() + 1);
    }

    public Integer getOredersCountOfPartner(String partnerId) {

        int count = 0;
        DeliveryPartner partner = partnerDb.get(partnerId);
        count = partner.getNumberOfOrders();
        return count;
    }

    public List<String> getOrdersByPartner(String partnerId) {

        List<String> orders = new ArrayList<>();
        for(String order:orderPartnerDb.keySet()){
            String partner = orderPartnerDb.get(order);
            if(partner.equals(partnerId)){
                orders.add(order);
            }
        }
        return orders;
    }

    public List<String> getAllOrders() {

        List<String> allOrders = new ArrayList<>();
        for(Order orders:orderDb.values()){
            String orderId = orders.getId();
            allOrders.add(orderId);
        }
        return  allOrders;
    }

    public Integer getUnassignedOrders() {
        int count = 0;
        for(String order:orderPartnerDb.keySet()){
            String partner = orderPartnerDb.get(order);
            if(partner == null){
                count++;
            }
        }
        return count;
    }

    public void deletePartner(String partnerId) {
        DeliveryPartner partner = partnerDb.get(partnerId);
        for(String order:orderPartnerDb.keySet()){
            if(orderPartnerDb.get(order).equals(partnerId)){
                orderPartnerDb.remove(order, null);
            }
        }
        partnerDb.remove(partnerId);
    }

    public void deleteOrder(String orderId) {

        Order order = orderDb.get(orderId);
        for(String orders:orderPartnerDb.keySet()){
            if(orders.equals(orderId)){
                orderPartnerDb.remove(orderId);
            }
        }
        orderDb.remove(orderId);
    }
}
