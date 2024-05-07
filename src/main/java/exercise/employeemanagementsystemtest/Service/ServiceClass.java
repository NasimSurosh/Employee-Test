package exercise.employeemanagementsystemtest.Service;

import exercise.employeemanagementsystemtest.Entity.Employee;
import exercise.employeemanagementsystemtest.Repository.RepositoryInterface;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ServiceClass implements Serviceinterface {

    private RepositoryInterface repository;

    public ServiceClass(RepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> findAllEmployee() {
        return repository.findAll();
    }

    @Override
    public Employee findEmployeeById(int id) {
        Employee employee = null;
        Optional<Employee> employees = repository.findById(id);
        if (employees.isPresent()) {
            employee = employees.get();
        }else{
            throw new RuntimeException("Employee not found");
        }
        return employee;
    }

    @Override
    @Transactional
    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        repository.deleteById(id);
    }
}
