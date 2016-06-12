/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.bean;

/**
 *
 * @author Divyansh
 */
public class Product {
    private String name;
    private String type;
    private float price;
    public static String BOOKS="Books";
    public static String MUSIC="Music";
    public static String COMP="Computers";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
}
