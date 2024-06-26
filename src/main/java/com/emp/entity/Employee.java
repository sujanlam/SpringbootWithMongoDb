package com.emp.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Employee")
@Data
public class Employee {
    @Id
    private String id;

    private String fname;
    private String lname;
    private String address;
    private int age;
    private double salary;
    private String sex;

}
