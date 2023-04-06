package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.data.entity.CustomerEntity;

public class CustomerRowMapper implements RowMapper<CustomerEntity> {

    @Override
    public CustomerEntity mapRow(ResultSet rs, int rowNumber) throws SQLException {
        return new CustomerEntity(rs.getLong("ID"),
                                  rs.getString("F_NAME"),
                                  rs.getString("L_NAME"),
                                  rs.getString("EMAIL"),
                                  rs.getString("PASSWORD"),
                                  rs.getString("ADDRESS"),
                                  rs.getString("PHONE"));
    }
}
