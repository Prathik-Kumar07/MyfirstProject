package com.example.deloitte.business;

import com.example.deloitte.dao.HealthCheckDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HealthCheckBusiness {

    @Autowired
    private HealthCheckDao healthCheckDao;

    public String getApplicationStatus() {

        return healthCheckDao.checkDbConnectivity();
    }
}
