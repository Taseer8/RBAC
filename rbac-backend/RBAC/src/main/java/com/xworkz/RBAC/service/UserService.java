package com.xworkz.RBAC.service;

import com.xworkz.RBAC.dto.UserDto;
import com.xworkz.RBAC.entity.UserEntity;

import java.util.List;

public interface UserService {
    public void save(UserDto dto);
//    boolean readById(String userName, String userPassword, String userRole);

    List<UserDto> getAllUsers();


    boolean getlog(String userName, String userPassword, String userRole);

    UserDto updateUser(int id, UserDto dto);

}
