package com.howudoin.backend.controller;

import com.howudoin.backend.model.User;
import com.howudoin.backend.payload.RegisterRequest;
import com.howudoin.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController
{
    @Autowired
    UserService userService;

    @PostMapping("/users/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequest registerRequest)
    {
        String message = userService.registerUser(registerRequest);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers()
    {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
