package com.example.myspringproject2.controller;

import com.example.myspringproject2.entity.User;
import com.example.myspringproject2.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public User[] getUsersList() throws JsonProcessingException {
        return userService.getUserList();
    }

    @GetMapping("/{id}")
    public User getUserId(@PathVariable String id) throws JsonProcessingException {
        return userService.getUser(id);

    }

    @GetMapping("/userByFirstName/{name}")
    public User[] getUsersByFirstName(@PathVariable String name) throws JsonProcessingException {
        return userService.getUserByFirstName(name);
    }

    @GetMapping("/userByLastName/{name}")
    public User[] getUsersByLastName(@PathVariable String name) throws JsonProcessingException {
        return userService.getUserByLastName(name);
    }

    @PostMapping("/")
    public String createUsers(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public String updateUsers(@PathVariable String id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUsers(@PathVariable String id) {
        return userService.deleteUser(id);
    }
}