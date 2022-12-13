package com.example.myspringproject2.service;

import com.example.myspringproject2.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service

public class UserService {
    @Autowired
    private RestTemplate restTemplate;
    ObjectMapper mapper = new ObjectMapper();

    public User[] getUserList() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<User[]> entity = new HttpEntity<>(headers);
        String userJson = restTemplate.exchange("http://localhost:8080/users", HttpMethod.GET, entity, String.class).getBody();
        User[] userList = mapper.readValue(userJson, User[].class);
        return userList;
    }

    public User getUser(@PathVariable("id") String id) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String userJson = restTemplate.exchange("http://localhost:8080/users/" + id, HttpMethod.GET, entity, String.class).getBody();
        System.out.println(userJson);
        User us = mapper.readValue(userJson, User.class);
        return us;
    }

    public User[] getUserByFirstName(@PathVariable String name) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String userJson = restTemplate.exchange("http://localhost:8080/users/userByFirstName/" + name, HttpMethod.GET, entity, String.class).getBody();
        User[] userFirst = mapper.readValue(userJson, User[].class);
        return userFirst;
    }

    public User[] getUserByLastName(@PathVariable String name) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String userJson = restTemplate.exchange("http://localhost:8080/users/userByLastName/" + name, HttpMethod.GET, entity, String.class).getBody();
        User[] userLast = mapper.readValue(userJson, User[].class);
        return userLast;
    }

    public String createUser(@RequestBody User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<User> entity = new HttpEntity<>(user, headers);

        return restTemplate.exchange(
                "http://localhost:8080/users/", HttpMethod.POST, entity, String.class).getBody();
    }

    public String updateUser(@PathVariable("id") String id, @RequestBody User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<User> entity = new HttpEntity<>(user, headers);

        return restTemplate.exchange(
                "http://localhost:8080/users/" + id, HttpMethod.PUT, entity, String.class).getBody();
    }

    public String deleteUser(@PathVariable("id") String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<User> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                "http://localhost:8080/users/" + id, HttpMethod.DELETE, entity, String.class).getBody();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
