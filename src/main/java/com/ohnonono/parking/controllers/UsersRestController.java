package com.ohnonono.parking.controllers;

import com.ohnonono.parking.model.User;
import com.ohnonono.parking.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/users")
public class UsersRestController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    @ApiOperation(value = "Get all users", notes = "Retrieving the collection of users", response = User[].class)
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(value = "/get/{id}")
    public User getById(@PathVariable String id) {
        return userService.findById(id);
    }

    @PostMapping("/save")
    public User newUser(@RequestBody User newUser) {
        return userService.saveOrUpdateUser(newUser);
    }
}
