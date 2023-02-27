package com.example.employee_payroll.respository;

import com.example.employee_payroll.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  EmployeePayrollRepository extends JpaRepository<EmployeePayrollData,Integer> {
}
