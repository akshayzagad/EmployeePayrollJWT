package com.example.employee_payroll.controller;

import com.example.employee_payroll.dto.EmployeePayrollDTO;
import com.example.employee_payroll.dto.ResponseDTO;
import com.example.employee_payroll.model.EmployeePayrollData;
import com.example.employee_payroll.service.IEService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/employeepayrollservice")
public class RestController {
    @Autowired
    IEService employeePayrollService;

    @RequestMapping(value = {"/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayroollData() {
        List<EmployeePayrollData> employeePayrollDataList;
        employeePayrollDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO responseDTO = new ResponseDTO("Fill The Required Filled", employeePayrollDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{token}")
    public ResponseEntity<ResponseDTO> getEmployeePayroollDataById(@PathVariable("token") String token) {
        EmployeePayrollData employeePayrollData;
        employeePayrollData = employeePayrollService.getEmployeePayrollDataById(token);
        ResponseDTO responseDTO = new ResponseDTO("Get call id Succsess", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayroollData(@Valid
                                                                      @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        log.debug("Employee DTO: "+employeePayrollDTO.toString());
        EmployeePayrollData employeePayrollData;
       String token = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Succsess", token);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/edit/{empID}")
    public ResponseEntity<ResponseDTO> updateEmployeePayroollData(@Valid
                                                                      @PathVariable("token") String token, @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData;
        employeePayrollData = employeePayrollService.updateEmployeePayrollData(token, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Edit Done", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayroollDataById(@PathVariable("token") String token) {
        EmployeePayrollData employeePayrollData;
        employeePayrollService.deleteEmployeePayrollData(token);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted Id:" + token);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }


}
