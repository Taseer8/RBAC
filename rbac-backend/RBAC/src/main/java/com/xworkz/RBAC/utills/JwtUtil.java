package com.xworkz.RBAC.utills;

import com.xworkz.RBAC.dto.UserDto;
import com.xworkz.RBAC.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

   public static UserEntity mapToEntity(UserDto dto){
       UserEntity entity = new UserEntity();
       if(dto!=null){
           dto.setUserName(entity.getUserName());
           dto.setUserEmail(entity.getUserEmail());
           dto.setUserRole(entity.getUserRole());
           dto.setUserPassWord(entity.getUserPassword());
           dto.setContactNumber(entity.getContactNumber());
           dto.setId(entity.getId());

           entity.setUserName(dto.getUserName());
           entity.setUserEmail(dto.getUserEmail());
           entity.setUserRole(dto.getUserRole());
           entity.setUserPassword(dto.getUserPassWord());
           entity.setContactNumber(dto.getContactNumber());

       }
       return entity;
   }
    public static UserDto mapToDto(UserEntity entity){
        UserDto dto = new UserDto();
        if(entity!=null){
            entity.setUserName(dto.getUserName());
            entity.setUserEmail(dto.getUserEmail());
            entity.setUserRole(dto.getUserRole());
            entity.setUserPassword(dto.getUserPassWord());
            entity.setContactNumber(dto.getContactNumber());

        }
        return dto;
    }
}
