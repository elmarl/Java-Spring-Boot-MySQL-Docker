package com.elmar.springboot.thymeleafdemo.controller;

import com.elmar.springboot.thymeleafdemo.entity.Employee;
import com.elmar.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// create employees controller, get, update, post employees.
@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // add mapping for /list, gets all employees
    @GetMapping("/list")
    private String listEmployees(Model model){
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employees/list-employees";
    }
    // add mapping to show form to add a new employee, use Model
    @GetMapping("/showFormAdd")
    private String showFormAdd(Model model){
        // create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }
    // add mapping to save an employee, get entered employee with @ModelAttribute
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        // save employee
        employeeService.saveEmployee(employee);
        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }
    // add mapping to show form for updating employee, get respective employee with id from database and fill the fields
    @GetMapping("/showFormUpdate")
    public String updateEmployee(@RequestParam("employeeId") int id,
                                 Model model){
        // get the employee from the service
        Employee employee = employeeService.findById(id);
        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        // send over to our form
        return "employees/employee-form";
    }
    // add mapping to delete an employee
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int id){
        // delete employee
        employeeService.deleteEmployee(id);
        // refresh
        return "redirect:/employees/list";
    }
}
