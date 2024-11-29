package com.xworkz.RBAC.controller;

import com.xworkz.RBAC.dto.UserDto;


import com.xworkz.RBAC.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;



@CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/register")
    public String save(@RequestBody UserDto userDto){
        userService.save(userDto);
        System.out.println(userDto);
        return "Data Saved";
    }
    @PostMapping("/signin")
    @CrossOrigin(origins = "http://localhost:3000/signin")
    public ResponseEntity<String> readById(@RequestParam("userName")  String userName, @RequestParam("userPassword") String userPassword, @RequestParam("userRole") String userRole) {
 if(userService.getlog(userName, userPassword, userRole)){
     return new ResponseEntity<>("Logged in", HttpStatus.ACCEPTED);
 }
       return new ResponseEntity<>("can't login", HttpStatus.BAD_REQUEST);
    }

    //build get all user details
    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUser(){
    List<UserDto> dto = userService.getAllUsers();
    return  ResponseEntity.ok(dto);
    }
@PutMapping ("/update")
    public ResponseEntity<UserDto> updateUser(@PathVariable int id ,
                                              @RequestBody UserDto dto){
    UserDto dto1 = userService.updateUser(id, dto);
    return  ResponseEntity.ok(dto1);
    }




}
