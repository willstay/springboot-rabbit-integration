package com.willstay.springbootrabbitintegration.rest.domain;

public class Suv implements AbstractCar {
    private String vin;
    private Long milage;
    private String location;
    private Long price; // kUsd

    public Suv(String vin, Long milage, String location, Long price) {
        this.vin = vin;
        this.milage = milage;
        this.location = location;
        this.price = price;
    }

    public Suv() {
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Long getMilage() {
        return milage;
    }

    public void setMilage(Long milage) {
        this.milage = milage;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
