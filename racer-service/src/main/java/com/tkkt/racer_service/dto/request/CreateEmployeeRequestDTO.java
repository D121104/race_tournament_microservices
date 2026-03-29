package com.tkkt.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequestDTO {
    @NotEmpty(message = "Chưa nhập username")
    private String username;
    @NotEmpty(message = "Chưa nhập username")
    private String password;
    @NotEmpty(message = "Chưa nhập họ tên")
    private String fullName;
    @NotEmpty(message = "Chưa nhập ngày sinh")
    private String dob;
    @NotEmpty(message = "Chưa nhập email")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Địa chỉ Email không hợp lệ")
    private String email;
    @NotEmpty(message = "Chưa nhập số điện thoại")
    @Pattern(regexp = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$", message = "Số điện thoại không hợp lệ")
    private String phone;

    @NotEmpty(message = "Cần nhập vai trò của nhân viên")
    private String role;

}
