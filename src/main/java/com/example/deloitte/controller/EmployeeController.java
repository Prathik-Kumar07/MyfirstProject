package com.example.deloitte.controller;


import com.example.deloitte.business.EmployeeBusiness;
import com.example.deloitte.dto.EmployeeDto;
import com.example.deloitte.service.EmployeeService;
import com.example.deloitte.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeBusiness employeeBusiness;
    @Autowired
    private EmployeeService employeeService;


    @RequestMapping(value ="/getAllEmployees",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
@ResponseBody()
    protected ResponseEntity<List<Map<String, Object>>> getAllEmployees(){
List<Map<String,Object>> employees=employeeBusiness.getAllmployees();
return ResponseEntity.ok(employees);

    }
    @RequestMapping(value ="/getEmployees",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody()
    protected ResponseEntity<List<Map<String, Object>>> getAllEmployeesWithPagination(@RequestParam int page,@RequestParam int size){
        List<Map<String,Object>> employees=employeeBusiness.getAllmployees(page,size);
        return ResponseEntity.ok(employees);

    }




    @PostMapping()
    public ApiResponse createEmployee(@RequestBody EmployeeDto employeeDto){
    System.out.println("Recieved Request : "+ employeeDto.getUserName());
        boolean isSaved= employeeService.saveEmployee(employeeDto);
        if(isSaved){
            return new ApiResponse("SUCCESS","Employee saved successfully");
        }else{
           return  new ApiResponse("FAILURE","Employee not saved") ;
        }


    }

}
