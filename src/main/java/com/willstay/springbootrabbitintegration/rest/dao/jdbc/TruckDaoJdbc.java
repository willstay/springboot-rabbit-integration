package com.willstay.springbootrabbitintegration.rest.dao.jdbc;

import com.willstay.springbootrabbitintegration.rest.dao.TruckDao;
import com.willstay.springbootrabbitintegration.rest.domain.Truck;
import com.willstay.springbootrabbitintegration.rest.mapper.TruckRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TruckDaoJdbc implements TruckDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Truck getTruckByVin(String vin) {
        return jdbcTemplate.queryForObject("SELECT * FROM Truck WHERE vin = ?",
                new TruckRowMapper(), vin);
    }

    @Override
    public List<Truck> getTruckAll() {
        return jdbcTemplate.query("SELECT * FROM Truck", new TruckRowMapper());
    }

    @Override
    public Truck insert(Truck tr) {
        jdbcTemplate.update("INSERT INTO Truck(VIN, MILAGE, LOCATION, PRICE, MAX_WEIGHT) VALUES (?, ?, ?, ?, ?)",
                tr.getVin(),tr.getMilage(),tr.getLocation(),tr.getPrice(),tr.getMaxWeight());
        return getTruckByVin(tr.getVin());
    }

    @Override
    public Truck update(Truck tr) {
        jdbcTemplate.update("UPDATE Truck SET MILAGE = ?, LOCATION = ?, PRICE = ?, MAX_WEIGHT = ? WHERE VIN = ?",
                tr.getMilage(),tr.getLocation(),tr.getPrice(),tr.getMaxWeight(),tr.getVin());
        return getTruckByVin(tr.getVin());
    }
}
