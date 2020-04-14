package com.elmar.springboot.thymeleafdemo.service;

import com.elmar.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.elmar.springboot.thymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }
    @Override
    public Employee findById(int id) {

        Optional<Employee> result = employeeRepository.findById(id);

        Employee employee = null;
        if (result.isPresent()){
            employee = result.get();
        } else {
            // we didnt find the epmloyee
            throw new RuntimeException("Did not find employee id: " + id);
        }
        return employee;
    }
    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
