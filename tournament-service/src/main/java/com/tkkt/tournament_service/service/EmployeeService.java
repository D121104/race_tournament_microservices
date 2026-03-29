package com.tkkt.service;

import com.tkkt.dto.ApiResponse;
import com.tkkt.dto.request.CreateEmployeeRequestDTO;
import com.tkkt.dto.request.LoginRequestDTO;
import com.tkkt.dto.response.CreateEmployeeResponseDTO;
import com.tkkt.dto.response.LoginResponseDTO;
import com.tkkt.entity.Employee;
import com.tkkt.exception.AppException;
import com.tkkt.exception.ErrorCode;
import com.tkkt.mapper.EmployeeMapper;
import com.tkkt.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Objects;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmployeeMapper employeeMapper;

//    @Transactional
//    public ApiResponse<LoginResponseDTO>  login(LoginRequestDTO loginRequest) {
//        Employee employee = employeeRepository.findByUsername(loginRequest.getUsername());
//        if (Objects.isNull(employee)) {
//            throw new AppException(ErrorCode.USERNAME_NOT_FOUND);
//        }
//        if (!passwordEncoder.matches(loginRequest.getPassword(), employee.getPassword())) {
//            throw new  AppException(ErrorCode.PASSWORD_MISMATCH);
//        }
//
//    }

    @Transactional
    public ApiResponse<CreateEmployeeResponseDTO> createEmployee(CreateEmployeeRequestDTO createRequest) {
        if (employeeRepository.existsByUsername(createRequest.getUsername())) {
            throw new AppException(ErrorCode.USERNAME_ALREADY_EXISTS);
        }
        createRequest.setPassword(passwordEncoder.encode(createRequest.getPassword()));
        Employee employee = Employee.builder()
                .username(createRequest.getUsername())
                .password(createRequest.getPassword())
                .dob(createRequest.getDob())
                .email(createRequest.getEmail())
                .phone(createRequest.getPhone())
                .role(createRequest.getRole())
                .build();
        employeeRepository.save(employee);
        return ApiResponse.<CreateEmployeeResponseDTO>builder()
                .result(employeeMapper.toCreateEmployeeResponseDTO(employee))
                .code(201)
                .message("Tạo tài khoản thành công")
                .build();
    }
}
