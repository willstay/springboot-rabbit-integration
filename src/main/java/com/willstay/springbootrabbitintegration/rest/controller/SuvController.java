package com.willstay.springbootrabbitintegration.rest.controller;

import com.willstay.springbootrabbitintegration.rest.dao.SuvDao;
import com.willstay.springbootrabbitintegration.rest.domain.Suv;
import com.willstay.springbootrabbitintegration.rest.service.SuvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/suv")
@RestController
public class SuvController {
    @Autowired
    private SuvDao suvDao;

    @GetMapping("/")
    List<Suv> findAll() {
        return suvDao.getSuvAll();
    }
    @GetMapping("/{vin}")
    Suv findById(@PathVariable("vin") String vin) {
        return suvDao.getSuvByVin(vin);
    }
}
