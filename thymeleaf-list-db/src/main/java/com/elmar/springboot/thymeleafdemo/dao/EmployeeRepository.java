package com.elmar.springboot.thymeleafdemo.dao;

import com.elmar.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// let spring boot automatically generate dao methods by extending with JpaRepository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // add a method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();
}
