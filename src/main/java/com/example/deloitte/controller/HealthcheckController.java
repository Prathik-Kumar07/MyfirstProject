package com.example.deloitte.controller;


import com.example.deloitte.business.HealthCheckBusiness;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healthCheck")
public class HealthcheckController {

    @Autowired
    private Gson gson;


    @Autowired
    private HealthCheckBusiness healthCheckBusiness;



    @RequestMapping(value = "/status",produces= MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)
    @ResponseBody
    protected ResponseEntity<String> getApplicationStatus(){
        String status=healthCheckBusiness.getApplicationStatus();
        if(StringUtils.isEmpty(status)){
            return ResponseEntity.status(HttpStatus.OK).body("Application is working Properly DB is connected");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gson.toJson(status));
    }

}
