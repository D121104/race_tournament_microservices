package com.tkkt.mapper;

import com.tkkt.dto.response.CreateEmployeeResponseDTO;
import com.tkkt.dto.response.LoginResponseDTO;
import com.tkkt.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    LoginResponseDTO toLoginResponseDTO(Employee employee);
    Employee toEmployee(LoginResponseDTO requestDTO);
    CreateEmployeeResponseDTO toCreateEmployeeResponseDTO(Employee employee);
}
