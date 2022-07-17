package com.trainh.assignmentprm.entities;

public class Cart {
    private int id;
    private int image;
    private String name;
    private double price;
    private double total;

    public Cart (int image, String name, double price, double total) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.total = total;
    }
    public Cart (int id, int image, String name, double price, double total) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.price = price;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
