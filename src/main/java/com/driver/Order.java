package com.driver;

public class Order {

    private String id;
    private int deliveryTime;

    public Order() {
    }

    public Order(String id, String deliveryTime) {
        this.id = id;
        int hour = Integer.valueOf(deliveryTime.substring(0,2));
        int minutes = Integer.valueOf(deliveryTime.substring(3));
        int time = hour * 60 + minutes;
        this.deliveryTime = time;
        // The deliveryTime has to converted from string to int and then stored in the attribute
        //deliveryTime  = HH*60 + MM
    }



    public void setId(String id) {
        this.id = id;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getId() {
        return id;
    }

    public int getDeliveryTime() {return deliveryTime;}

}
