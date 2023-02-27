package com.example.employee_payroll.service;

import com.example.employee_payroll.dto.EmployeePayrollDTO;
import com.example.employee_payroll.dto.ResponseDTO;
import com.example.employee_payroll.exception.EmpPayRollException;
import com.example.employee_payroll.model.EmployeePayrollData;
import com.example.employee_payroll.respository.EmployeePayrollRepository;
import com.example.employee_payroll.utility.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEService {
    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;
    @Autowired
    Token token1;

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {

        return employeePayrollRepository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(String token) {
        int userId = token1.decodeToken(token);
        return employeePayrollRepository.findById(userId)
                .orElseThrow(() -> new EmpPayRollException("ID Not Found"));
    }

    @Override
    public String createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData;
        employeePayrollData = new EmployeePayrollData(empPayrollDTO);
        log.debug("employeePayrollData: " + employeePayrollData.toString());
        EmployeePayrollData employeePayrollData1 = employeePayrollRepository.save(employeePayrollData);
        String tokenId = token1.createToken(employeePayrollData1.getEmployeeId());
        return tokenId;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(String tokens, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(tokens);
        employeePayrollData.updateEmployeePayrollData(employeePayrollDTO);
        return employeePayrollRepository.save(employeePayrollData);
    }

    @Override
    public void deleteEmployeePayrollData(String token) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(token);
        employeePayrollRepository.delete(employeePayrollData);
    }
}
