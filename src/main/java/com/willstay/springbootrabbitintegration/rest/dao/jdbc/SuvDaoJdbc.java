package com.willstay.springbootrabbitintegration.rest.dao.jdbc;

import com.willstay.springbootrabbitintegration.rest.dao.SuvDao;
import com.willstay.springbootrabbitintegration.rest.domain.Suv;
import com.willstay.springbootrabbitintegration.rest.mapper.SuvRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SuvDaoJdbc implements SuvDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Suv getSuvByVin(String vin) {
        return jdbcTemplate.queryForObject("SELECT * FROM Suv WHERE vin = ?",
                new SuvRowMapper(), vin);
    }

    @Override
    public List<Suv> getSuvAll() {
        return jdbcTemplate.query("SELECT * FROM Suv", new SuvRowMapper());
    }

    @Override
    public Suv insert(Suv suv) {
        jdbcTemplate.update("INSERT INTO Suv(VIN, MILAGE, LOCATION, PRICE) VALUES (?, ?, ?, ?)",
                suv.getVin(), suv.getMilage(), suv.getLocation(), suv.getPrice());
        return getSuvByVin(suv.getVin());
    }

    @Override
    public Suv update(Suv suv) {
        jdbcTemplate.update("UPDATE Suv SET MILAGE = ?, LOCATION = ?, PRICE = ? WHERE VIN = ?",
                suv.getMilage(), suv.getLocation(), suv.getPrice(), suv.getVin());
        return getSuvByVin(suv.getVin());
    }
}
