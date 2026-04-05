package com.example.deloitte.dao;

import com.example.deloitte.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;



@Repository
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


    public int saveEmployees(EmployeeDto dto){
    String sql="Insert into employee (username,department_id,salary,age,date_of_joining) "+ "values (?,?,?,?,?)";
    return jdbcTemplate.getJdbcOperations().update(sql,dto.getUserName(),dto.getDepartmentId(),dto.getSalary(),dto.getAge(),dto.getDoj());

    }

}


