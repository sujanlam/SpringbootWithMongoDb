package com.emp.controller;

import com.emp.entity.Employee;
import com.emp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public List<Employee> getAll() {
        List<Employee> empsByModel = empService.getAllemps();
        return empsByModel;
    }

    @GetMapping("/{id}")
    public Optional<Employee> getempById(@PathVariable Long id) {
        return empService.getOneEmp(id);
    }

    @PostMapping
    public void createEmp(@RequestBody Employee emp) {
        empService.createEmp(emp);
    }

    @GetMapping("/fname/{fname}")
    public List<Employee> getempByModel(@PathVariable String fname) {
        List<Employee> empsByFName = empService.getempssByFirstName(fname);
        return empsByFName;
    }

    @GetMapping("/lname/{lname}")
    public List<Employee> getempByLastName(@PathVariable String lname) {
        List<Employee> empsByLName = empService.getempssByFirstName(lname);
        return empsByLName;
    }


    @GetMapping("/salarybelow/{salary}")
    public List<Employee> empsBelowSalary(@PathVariable double salary) {
        List<Employee> empsBelowGivenSalary = empService.empssBelow(salary);
        return empsBelowGivenSalary;
    }

    @GetMapping("/sexAndAge")
    public List<Employee> getempsByModelAndPrice(@RequestParam String sex, @RequestParam Double age
    ) {
        return empService.findEmpBySexAndAge(sex, age);
    }

    @DeleteMapping("/{id}")
    public void deleteempById(@PathVariable Long id){
        empService.deleteEmp(id);
    }

    @PutMapping("/{id}")
    public void updateempById(@PathVariable Long id, @RequestBody Employee emp){
        empService.updateEmp(id, emp);
    }

}
