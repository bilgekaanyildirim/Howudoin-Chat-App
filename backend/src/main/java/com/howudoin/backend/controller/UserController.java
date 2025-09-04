package com.howudoin.backend.controller;

import com.howudoin.backend.payload.RegisterRequest;
import com.howudoin.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
