package com.willstay.springbootrabbitintegration.rest.dao;

import com.willstay.springbootrabbitintegration.rest.domain.Truck;

import java.util.List;

public interface TruckDao {
    Truck getTruckByVin(String vin);

    List<Truck> getTruckAll();

    Truck insert(Truck truck);

    Truck update(Truck truck);
}
