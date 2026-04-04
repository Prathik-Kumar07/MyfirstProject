package com.example.deloitte.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
public class EmployeeDao {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

public List<Map<String,Object>> getAllEmployees(){

    String sql="select top 100 username,department_id ,salary from Employee";
    return jdbcTemplate.getJdbcOperations().queryForList(sql);



}


    public List<Map<String, Object>> getAllEmployees(int page, int size) {

    int offset=page*size;
    String sql ="Select username,department_id,salary "+"From Employee "+"Order by id "+"offset ? Rows fetch next ? rows only ";

    return jdbcTemplate.getJdbcOperations().queryForList(sql,offset,size);
    }
}
