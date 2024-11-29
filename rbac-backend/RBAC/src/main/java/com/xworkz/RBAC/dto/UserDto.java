package com.xworkz.RBAC.dto;

import com.xworkz.RBAC.Enum.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String userName;
    private String userEmail;
    private String userPassWord;
    private String userRole;
    private String contactNumber;


}
