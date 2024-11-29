package com.xworkz.RBAC.service;

import com.xworkz.RBAC.dto.UserDto;
import com.xworkz.RBAC.entity.UserEntity;
import com.xworkz.RBAC.repo.UserRepo;
import com.xworkz.RBAC.utills.JwtUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepo repo;

    @Override
    //save operation
    public void save(UserDto dto) {
        UserEntity entity = new UserEntity();
        if (dto != null) {
            entity.setUserName(dto.getUserName());
            entity.setUserEmail(dto.getUserEmail());
            entity.setUserRole(dto.getUserRole());
            entity.setUserPassword(dto.getUserPassWord());
            entity.setContactNumber(dto.getContactNumber());
            repo.save(entity);
            System.out.println(dto);
        } else {
            System.out.println("cant saved");
        }
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> entity = repo.findAll();
        return entity.stream().map((entity1) -> JwtUtil.mapToDto(entity1))
                .collect(Collectors.toList());
    }

    @Override
    public boolean getlog(String userName, String userPassword, String userRole) {
        UserDto dto = new UserDto();
//
        UserEntity entity = repo.getUser(userName, userPassword, userRole);
        if (entity != null) {
            if (entity.getUserName().equals(userName) && entity.getUserPassword().equals(userPassword)
                    && entity.getUserRole().equals(userRole)) {
                BeanUtils.copyProperties(entity, dto);

            }
            System.out.println(dto);
            return true;
        }
        return false;
    }

    @Override
    public UserDto updateUser(int id,UserDto dto) {

        UserEntity entity = new UserEntity();
        if (repo.findById(id).isPresent()) {
            entity.setUserName(dto.getUserName());
            entity.setUserEmail(dto.getUserEmail());
            entity.setUserRole(dto.getUserRole());
            entity.setUserPassword(dto.getUserPassWord());
            entity.setContactNumber(dto.getContactNumber());
            repo.save(entity);

        } else {
            System.out.println("user not found ");

        }
        return null;
    }

}