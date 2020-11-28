package com.company.model;

public class Vehicle {


    private int id;
    private String brand;
    private String model;
    private double price;
    private boolean isAvailable;



    public Vehicle(int id, String brand, String model, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.isAvailable = true;
    }
    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void rent() {
        this.setAvailable(false);
    }

    public void returnVehicle() {
        this.setAvailable(true);
    }

    @Override
    public String toString() {
        return "Vehicle:" + id + ", brand: " + ", model: ";
    }
}
