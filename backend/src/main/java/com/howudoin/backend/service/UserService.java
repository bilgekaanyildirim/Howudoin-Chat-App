package com.howudoin.backend.service;

import com.howudoin.backend.model.User;
import com.howudoin.backend.payload.RegisterRequest;

import java.util.List;

public interface UserService
{
    String registerUser(RegisterRequest registerRequest);

    List<User> getAllUsers();
}
