package com.emp.repo;

import com.emp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmpRepository extends MongoRepository<Employee, Long> {
    List<Employee> findByFname(String fName);
    List<Employee> findByLname(String lName);
    List<Employee> findCarsBySalaryBefore(double salary);
    List<Employee> findBySexAndAge(String sex, double age);

}
