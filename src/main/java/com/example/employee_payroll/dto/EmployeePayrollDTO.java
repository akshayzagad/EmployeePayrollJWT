package com.example.employee_payroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public @Data class EmployeePayrollDTO {
    @NotEmpty(message = "Please Enter your firstName")
    @Pattern(regexp = "^[A-Z]{1}[a-z]{3,}$",message = "Please enter valid name")
    public String name;
    @Min(value = 500,message = "Minimum salary should be 500")
    @NotNull(message = "salary field cannot be empty")
    public long salary;
    @Pattern(regexp = "male|female",message = "Gender may be male or female")
    public String gender;
    @NotBlank(message = "Note can not be null")
    public String note;
    @NotBlank(message = "profilePic can not be null")
    public String profilePic;
    @NotNull(message = "department Date should not be empty")
    public List<String> department;
}
