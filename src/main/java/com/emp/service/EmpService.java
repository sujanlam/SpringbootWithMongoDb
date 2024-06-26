package com.emp.service;

import com.emp.entity.Employee;
import com.emp.repo.EmpRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    Logger logger = LogManager.getLogger(EmpService.class);
    @Autowired
    private EmpRepository empsRepository;

    public List<Employee> getAllemps() {
        logger.info("We are starting the execution of findAll method in service.");
        List<Employee> empssList = empsRepository.findAll();
        logger.info("List of all empss: "+ empssList);
        return empssList;
    }

    public Optional<Employee> getOneEmp(Long id) {
        return empsRepository.findById(id);
    }

    public List<Employee> getempssByFirstName(String fname) {
        List<Employee> empByFName = empsRepository.findByFname(fname);
        return empByFName;
    }

    public List<Employee> getempssByLastName(String fname) {
        List<Employee> empByLName = empsRepository.findByFname(fname);
        return empByLName;
    }

    public void createEmp(Employee emp) {
        empsRepository.save(emp);
    }

    public List<Employee> empssBelow(double salary) {
        List<Employee> empssListBelowGivenSalary = empsRepository.findCarsBySalaryBefore(salary);
        return empssListBelowGivenSalary;
    }

    public List<Employee> findEmpBySexAndAge(String sex, Double age) {
        return empsRepository.findBySexAndAge(sex, age);
    }

    public void updateEmp(Long id, Employee updatedEmployee){
        Optional<Employee> optionalemps = empsRepository.findById(id);

        if(optionalemps.isPresent()){
            Employee existingEmployee = optionalemps.get();
            existingEmployee.setFname(updatedEmployee.getFname());
            existingEmployee.setLname(updatedEmployee.getLname());
            existingEmployee.setAge(updatedEmployee.getAge());
            existingEmployee.setAddress(updatedEmployee.getAddress());
            existingEmployee.setSalary(updatedEmployee.getSalary());
            existingEmployee.setSex(updatedEmployee.getSex());

            empsRepository.save(existingEmployee);
        }
        else {
            throw new IllegalArgumentException("emps with "+ id+ " Not found!!!");
        }
    }

    public void deleteEmp(Long id){
        empsRepository.deleteById(id);
    }

}
