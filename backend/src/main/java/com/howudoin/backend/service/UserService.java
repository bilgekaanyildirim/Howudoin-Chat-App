package com.howudoin.backend.service;

import com.howudoin.backend.payload.RegisterRequest;

public interface UserService
{
    String registerUser(RegisterRequest registerRequest);
}
