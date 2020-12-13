package com.harbour.webapp.controllers;

import com.harbour.webapp.entities.Employee;
import com.harbour.webapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees")
    public String employeesPage(Model model){
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees",employees);
        return "/employees";
    }

    @GetMapping("/employee/details/{id}")
    public String employeeDetailsPage(Model model, @PathVariable(name = "id") Long id){
        Employee selectedEmployee = employeeService.getEmployeeById(id);
        model.addAttribute("employee",selectedEmployee);
        return "employee-details";
    }

    @RequestMapping(value = "/employee/add",method = RequestMethod.GET)
    public String employeeAddPage(Model model){
        model.addAttribute("employee",new Employee());
        return "employee-add";
    }

    @RequestMapping(value = "/employee/add",method = RequestMethod.POST)
    public String employeeAddSubmit(@ModelAttribute Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employee/delete/{id}")
    public String deleteEmployeeById(@PathVariable(name = "id") Long id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employee/edit/{id}",method = RequestMethod.GET)
    public String employeeEditPage(Model model,@PathVariable(name = "id") Long id){
        Employee selectedEmployee = employeeService.getEmployeeById(id);
        model.addAttribute("employee",selectedEmployee);
        return "employee-edit";
    }

    @RequestMapping(value = "/employee/edit",method = RequestMethod.POST)
    public String employeeEditSubmit(@ModelAttribute Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }
}
