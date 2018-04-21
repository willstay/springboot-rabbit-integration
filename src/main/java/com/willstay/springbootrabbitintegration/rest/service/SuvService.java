package com.willstay.springbootrabbitintegration.rest.service;

import com.willstay.springbootrabbitintegration.rest.dao.SuvDao;
import com.willstay.springbootrabbitintegration.rest.domain.Suv;
import com.willstay.springbootrabbitintegration.rest.domain.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SuvService {
    @Autowired
    private SuvDao suvDao;

    public Suv getSuvByVin(String vin) {
        return suvDao.getSuvByVin(vin);
    }

    public List<Suv> getSuvAll() {
        return suvDao.getSuvAll();
    }

    public Suv save(Suv suv) {
        try {
            suvDao.getSuvByVin(suv.getVin());
            return suvDao.update(suv);
        } catch (EmptyResultDataAccessException e){
            return suvDao.insert(suv);
        }
    }
}
