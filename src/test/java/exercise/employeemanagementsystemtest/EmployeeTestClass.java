package exercise.employeemanagementsystemtest;

import exercise.employeemanagementsystemtest.Entity.Employee;
import exercise.employeemanagementsystemtest.Repository.RepositoryInterface;
import exercise.employeemanagementsystemtest.Service.ServiceClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class EmployeeTestClass {
    @Mock
    private RepositoryInterface repository;

    @InjectMocks
    private ServiceClass serviceClass;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void getAllEmployeesTest() {
        List<Employee> findAllEmployee = Arrays.asList(new Employee("Nasim","Surosh","abs@example.com"),
                new Employee("Sana","Surosh","SS@example.com"),
                new Employee("Mastorah","Surodh","ms@example.com"));

        when(repository.findAll()).thenReturn(findAllEmployee);
        List<Employee> employees = serviceClass.findAllEmployee();
        assertEquals(3, employees.size());
    }

    @Test
    void getEmployeeByIdTest() {
        Employee findEmployee = new Employee("Nasim","Surosh","abs@example.com");
        findEmployee.setId(1);
        when(repository.findById(1)).thenReturn(Optional.of(findEmployee));
        Employee employee = serviceClass.findEmployeeById(1);
        assertNotNull(findEmployee);
        assertEquals(1, employee.getId());
        assertEquals("Nasim", employee.getFirstName());
        assertEquals("Surosh", employee.getLastName());
        assertEquals("abs@example.com", employee.getEmail());

    }

    @Test
    void saveEmployeeTest() {
        Employee saveEmployee = new Employee("Nasim","Surosh","abs@example.com");
        when(repository.save(saveEmployee)).thenReturn(saveEmployee);
        Employee employee = serviceClass.addEmployee(saveEmployee);
        assertNotNull(employee);
        assertEquals("Nasim", employee.getFirstName());
        assertEquals("Surosh", employee.getLastName());
        assertEquals("abs@example.com", employee.getEmail());

    }

    @Test
    void deleteEmployeeTest() {
        repository.deleteById(1);
        verify(repository,times(1)).deleteById(1);
    }
}
