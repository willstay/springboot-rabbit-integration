package com.willstay.springbootrabbitintegration.rest.mapper;

import com.willstay.springbootrabbitintegration.rest.domain.Suv;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SuvRowMapper implements RowMapper<Suv> {

    @Override
    public Suv mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Suv(
                resultSet.getString("vin"),
                resultSet.getLong("milage"),
                resultSet.getString("location"),
                resultSet.getLong("price")
        );
    }
}
