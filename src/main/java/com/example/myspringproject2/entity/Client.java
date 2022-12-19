package com.example.myspringproject2.entity;

import com.example.myspringproject2.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@FeignClient(name = "mySpringProject", url = "http://localhost:8080/users")
public interface Client {
    @GetMapping("")
    User[] getUsers();

    @GetMapping("/{id}")
    User getById(@PathVariable("id") Long id);

    @GetMapping("/userByFirstName/{name}")
    User[] getUserByFirstName(@PathVariable String name);

    @GetMapping("/userByLastName/{name}")
    User[] getUserByLastName(@PathVariable String name);

    @PostMapping("/")
    User createUser(@RequestBody User user);

    @PutMapping("/{id}")
    User updateUser(@PathVariable("id") Long id, @RequestBody User user);

    @DeleteMapping("/{id}")
    User deleteUser(@PathVariable("id") Long id);

}
