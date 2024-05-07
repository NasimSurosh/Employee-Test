package exercise.employeemanagementsystemtest.Repository;

import exercise.employeemanagementsystemtest.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryInterface extends JpaRepository<Employee, Integer> {
}
