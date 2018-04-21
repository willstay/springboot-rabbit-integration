package com.willstay.springbootrabbitintegration.rest.controller;

import com.willstay.springbootrabbitintegration.rest.dao.TruckDao;
import com.willstay.springbootrabbitintegration.rest.domain.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/truck")
@RestController
public class TruckController {
    @Autowired
    private TruckDao truckDao;

    @GetMapping("/")
    List<Truck> findAll() {
        return truckDao.getTruckAll();
    }
    @GetMapping("/{vin}")
    Truck findById(@PathVariable("vin") String vin) {
        return truckDao.getTruckByVin(vin);
    }
}
