package com.threepounds.baseservice.shared.sharedorder;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderResource {
    private String restaurantName;
    private List<String> foodName;
    private String name;
    private String note;
    private String price;
    private String date;
    private String paymentType;

    public OrderResource() {

    }

    public OrderResource(String restaurantName, List<String> foodName, String name, String note, String price, String date, String paymentType) {
        this.restaurantName = restaurantName;
        this.foodName = foodName;
        this.name = name;
        this.note = note;
        this.price = price;
        this.date = date;
        this.paymentType = paymentType;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public List<String> getFoodName() {
        return foodName;
    }

    public void setFoodName(List<String> foodName) {
        this.foodName = foodName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "OrderResource{" +
                "restaurantName='" + restaurantName + '\'' +
                ", foodName=" + foodName +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                ", price='" + price + '\'' +
                ", date='" + date + '\'' +
                ", paymentType='" + paymentType + '\'' +
                '}';
    }
}
