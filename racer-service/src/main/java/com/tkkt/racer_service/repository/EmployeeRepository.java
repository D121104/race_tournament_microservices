package com.tkkt.repository;

import com.tkkt.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository< Employee, Long> {
    boolean existsByUsername(String username);
    Employee findByUsername(String username);
}
