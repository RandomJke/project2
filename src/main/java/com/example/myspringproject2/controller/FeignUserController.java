package com.example.myspringproject2.controller;

import com.example.myspringproject2.entity.Client;
import com.example.myspringproject2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class FeignUserController {
    @Autowired
    Client client;

    @GetMapping("")
    public User[] getUsers() {
        return client.getUsers();
    }

    @GetMapping("/userByFirstName/{name}")
    public User[] getUserByFirstName(@PathVariable String name) {
        return client.getUserByFirstName(name);
    }

    @GetMapping("/userByLastName/{name}")
    public User[] getUserByLastName(@PathVariable String name) {
        return client.getUserByLastName(name);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Long id) {
        return client.getById(id);
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        return client.createUser(user);
    }

    @PutMapping("/{id}")
    public User addUser(@PathVariable("id") Long id, @RequestBody User user) {
        return client.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable("id") Long id) {
        return client.deleteUser(id);
    }
}
