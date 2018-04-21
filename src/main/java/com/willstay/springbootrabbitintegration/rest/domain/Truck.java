package com.willstay.springbootrabbitintegration.rest.domain;

public class Truck implements AbstractCar {

    private String vin;
    private Long milage;
    private String location;
    private Long price; // kUsd
    private Long maxWeight; // kg

    public Truck(String vin, Long milage, String location, Long price, Long maxWeight) {

        this.vin = vin;
        this.milage = milage;
        this.location = location;
        this.price = price;
        this.maxWeight = maxWeight;
    }

    public Truck() {
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

    public Long getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Long maxWeight) {
        this.maxWeight = maxWeight;
    }
}
