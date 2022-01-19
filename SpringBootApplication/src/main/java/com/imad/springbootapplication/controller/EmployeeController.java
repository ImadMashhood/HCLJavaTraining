package com.imad.springbootapplication.controller;

import com.imad.springbootapplication.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController{
    @GetMapping("/emp")
    public List<Employee> getAllEmp(){
        return Arrays.asList(new Employee(100,"21313 Imad Mashhood", "Test Addy"),
                new Employee(102,"Not Mashhood", "6455 Test Addy"),
                new Employee(103,"Imad Not", "7686 Test Addy"));
    }
}
