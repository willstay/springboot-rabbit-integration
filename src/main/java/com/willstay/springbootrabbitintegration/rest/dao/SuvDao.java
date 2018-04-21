package com.willstay.springbootrabbitintegration.rest.dao;

import com.willstay.springbootrabbitintegration.rest.domain.Suv;

import java.util.List;

public interface SuvDao {
    Suv getSuvByVin(String vin);

    List<Suv> getSuvAll();

    Suv insert(Suv suv);

    Suv update(Suv suv);
}
