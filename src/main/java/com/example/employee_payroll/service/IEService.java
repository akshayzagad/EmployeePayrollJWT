package com.example.employee_payroll.service;

import com.example.employee_payroll.dto.EmployeePayrollDTO;
import com.example.employee_payroll.model.EmployeePayrollData;

import java.util.List;

public interface IEService {
    List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(String token);

    String createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);


    EmployeePayrollData updateEmployeePayrollData(String token, EmployeePayrollDTO employeePayrollDTO);

    void deleteEmployeePayrollData(String token);
}
