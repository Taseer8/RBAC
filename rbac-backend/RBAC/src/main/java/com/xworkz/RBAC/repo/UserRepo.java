package com.xworkz.RBAC.repo;

import com.xworkz.RBAC.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

@EnableJpaRepositories
public interface UserRepo extends JpaRepository<UserEntity, Integer> {

    @Query("SELECT u FROM UserEntity u WHERE u.userName = :username AND u.userPassword = :userPassWord AND u.userRole = :userRole")
    UserEntity getUser(
            @Param("username") String username,
            @Param("userPassWord") String userPassWord,
            @Param("userRole") String userRole
    );



}
