package com.tkkt.controller;

import com.tkkt.dto.ApiResponse;
import com.tkkt.dto.request.CreateEmployeeRequestDTO;
import com.tkkt.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/enmployees")
public class EmployeeController {
    @Autowired
    private final EmployeeService employeeService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> registerEmployee(@RequestBody @Valid CreateEmployeeRequestDTO request) {
        ApiResponse response = employeeService.createEmployee(request);
        if  (response.getCode() == HttpStatus.BAD_REQUEST.value()) {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
