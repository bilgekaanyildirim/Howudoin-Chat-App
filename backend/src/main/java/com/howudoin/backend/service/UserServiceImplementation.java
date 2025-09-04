package com.howudoin.backend.service;

import com.howudoin.backend.model.User;
import com.howudoin.backend.payload.RegisterRequest;
import com.howudoin.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService
{
    //Neden interface kullandık?

    @Autowired
    UserRepository userRepository;

    @Override
    public String registerUser(RegisterRequest registerRequest)
    {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());

        userRepository.save(user);
        return "User registered successfully";
    }

    @Override
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }
}
