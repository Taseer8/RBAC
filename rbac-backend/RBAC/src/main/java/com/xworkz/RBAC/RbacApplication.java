package com.xworkz.RBAC;

import com.xworkz.RBAC.Enum.Role;
import com.xworkz.RBAC.dto.UserDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RbacApplication {

	public static void main(String[] args) {
		SpringApplication.run(RbacApplication.class, args);
		System.out.println("welcome to spring");
	}

}
