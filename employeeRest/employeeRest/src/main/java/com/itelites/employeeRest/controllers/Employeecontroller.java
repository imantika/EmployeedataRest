package com.itelites.employeeRest.controllers;

import com.itelites.employeeRest.exceptionHandlers.exception;
import com.itelites.employeeRest.models.EmployeeData;
import com.itelites.employeeRest.repositories.Employeerepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/employees")
public class Employeecontroller {

    @Autowired
    private RestTemplate restTemplate;
   @Autowired
   private Employeerepo repo;
    @PostMapping("/createData")
    public EmployeeData addData(@RequestBody EmployeeData employee){
        return repo.save(employee);
    }
    @PutMapping("/update/{empId}")
    public EmployeeData updateData(@PathVariable String empId, @RequestBody EmployeeData employee){
        EmployeeData existingData = repo.findById(empId).orElseThrow(()->new exception("employee with ID -> " + empId + " not found,update failed"));
        employee.setName(employee.getName());
        employee.setAddress(employee.getAddress());
        employee.setDepartment(employee.getDepartment());
        return repo.save(employee);
    }

    @GetMapping("/fetchEmployee/{empId}")
    public EmployeeData fetchEmployee(@PathVariable String empId){
        EmployeeData employee = repo.findById(empId).orElseThrow(()->new exception("employee with ID -> " + empId + " not found,fetching failed"));
        return (employee);
    }
    @GetMapping("/filterEmployeesByDep/{department}")
    public List<EmployeeData> employeesByDepartment(@PathVariable String department){
        return repo.findAll().stream().filter(x -> x.getDepartment().contains(department)).collect(Collectors.toList());
    }
    @GetMapping("/findAll")

        public List<EmployeeData> employees(){
            return repo.findAll();

    }
}




