package com.willstay.springbootrabbitintegration.rest.service;

import com.willstay.springbootrabbitintegration.rest.dao.TruckDao;
import com.willstay.springbootrabbitintegration.rest.domain.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TruckService {
    @Autowired
    private TruckDao truckDao;

    public Truck getTruckByVin(String vin){
        return truckDao.getTruckByVin(vin);
    }

    public List<Truck> getTruckAll() {
        return truckDao.getTruckAll();
    }
    public Truck save(Truck truck) {
        try {
            truckDao.getTruckByVin(truck.getVin());
            return truckDao.update(truck);
        } catch (EmptyResultDataAccessException e){
            return truckDao.insert(truck);
        }
    }

}
