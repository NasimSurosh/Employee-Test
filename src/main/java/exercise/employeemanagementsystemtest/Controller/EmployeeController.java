package exercise.employeemanagementsystemtest.Controller;

import exercise.employeemanagementsystemtest.Entity.Employee;
import exercise.employeemanagementsystemtest.Service.Serviceinterface;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private Serviceinterface serviceinterface;
    @Autowired
    public EmployeeController(Serviceinterface serviceinterface) {
        this.serviceinterface = serviceinterface;
    }
    @GetMapping("/list")
    public List<Employee> getAllEmployees() {
        List<Employee> employees = serviceinterface.findAllEmployee();
        return employees;
    }
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return serviceinterface.addEmployee(employee);
    }
    @GetMapping("/get/{id}")
    public Employee getEmployee(@PathVariable int id) {
       return serviceinterface.findEmployeeById(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable int id) {
        serviceinterface.deleteEmployee(id);
    }

}
