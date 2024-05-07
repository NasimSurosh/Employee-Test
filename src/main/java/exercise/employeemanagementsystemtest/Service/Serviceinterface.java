package exercise.employeemanagementsystemtest.Service;


import exercise.employeemanagementsystemtest.Entity.Employee;

import java.util.List;

public interface Serviceinterface {

    List<Employee> findAllEmployee();
    Employee findEmployeeById(int id);
    Employee addEmployee(Employee employee);
    void deleteEmployee(int id);

}
