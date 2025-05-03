package com.example.Microservice2Demo;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private Double price;
    private Long userId;

    public Order(){}

    public Order(String itemName,Double price, Long userId) {
        this.itemName=itemName;
        this.price=price;
        this.userId=userId;
    }

    public String getItemName(){
        return itemName;
    }

    public Double getPrice(){
        return price;
    }

    public Long getUserId(){
        return userId;
    }

    public void setItemName(String itemName){
        this.itemName=itemName;
    }

    public void setPrice(Double price){
        this.price=price;
    }

    public void setUserId(Long userId){
        this.userId=userId;
    }

}

