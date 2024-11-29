package com.xworkz.RBAC.entity;

import com.xworkz.RBAC.Enum.Role;
import jakarta.persistence.*;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "UserEntity")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_email")
    private String userEmail;
    @Column (name = "user_password")
    private String userPassword;
    @Column(name = "role")
    private String userRole;
    @Column(name = "user_c_number")
    private String contactNumber;
}
