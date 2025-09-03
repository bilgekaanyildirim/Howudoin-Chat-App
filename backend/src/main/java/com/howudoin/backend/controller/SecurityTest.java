package com.howudoin.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class SecurityTest
{
    @PostMapping("/hello")
    public String hello()
    {
        return "hello";
    }
}
