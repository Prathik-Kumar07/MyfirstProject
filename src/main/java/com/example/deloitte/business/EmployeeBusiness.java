package com.example.deloitte.business;


import com.example.deloitte.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class EmployeeBusiness {


    @Autowired
    EmployeeDao employeeDao;

    public List<Map<String,Object>> getAllmployees(){

        return employeeDao.getAllEmployees();

    }

    public List<Map<String, Object>> getAllmployees(int page, int size) {
        return employeeDao.getAllEmployees( page, size);
    }

   }
