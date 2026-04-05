package com.example.deloitte.service;

import com.example.deloitte.dao.EmployeeDao;
import com.example.deloitte.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    public boolean saveEmployee(EmployeeDto dto){
        System.out.println("Insside service : "+ dto.getUserName());

        return employeeDao.saveEmployees(dto) > 0;
    }
}
