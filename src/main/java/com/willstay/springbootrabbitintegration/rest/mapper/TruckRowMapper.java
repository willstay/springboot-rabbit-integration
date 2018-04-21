package com.willstay.springbootrabbitintegration.rest.mapper;

import com.willstay.springbootrabbitintegration.rest.domain.Truck;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TruckRowMapper implements RowMapper <Truck>{

    @Override
    public Truck mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Truck(
                resultSet.getString("vin"),
                resultSet.getLong("milage"),
                resultSet.getString("location"),
                resultSet.getLong("price"),
                resultSet.getLong("max_weight")
        );
    }
}
