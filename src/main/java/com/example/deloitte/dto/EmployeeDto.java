package com.example.deloitte.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeDto {
    private String username;
    private int departmentId;
    private int salary;
    private int age;
    private String doj;

    public String getUserName() {
        return username;
    }

    @JsonProperty(value = "name")
    public void setUserName(String name) {
        this.username = name;//advisory to make payload and dto names as same but just in case for quick fix use @Jsonproperty
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }
}
