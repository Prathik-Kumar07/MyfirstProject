package com.example.deloitte.dao;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class HealthCheckDao {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public String checkDbConnectivity() {
        try {
            jdbcTemplate.getJdbcOperations().queryForList("SELECT 1");
        }catch (Exception e){
            return "DB connection failed: "+e.getMessage();
        }
        return "";
    }
}
