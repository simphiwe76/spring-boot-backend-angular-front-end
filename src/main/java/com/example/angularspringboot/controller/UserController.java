package com.example.angularspringboot.controller;

import com.example.angularspringboot.model.User;
import com.example.angularspringboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "user")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {

    private  final UserService userService;

    @PostMapping
    public  User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getUsersList(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public  User getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @PutMapping(value = "/{id}")
    public  User updateUser(@PathVariable("id") Long id,@RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping(value = "/{id}")
    public  List<User> deleteUser(@PathVariable("id") Long id){
        return userService.deleteUser(id);
    }
}
