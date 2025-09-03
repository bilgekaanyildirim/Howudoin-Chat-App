package com.howudoin.backend.controller;

import com.howudoin.backend.model.Message;
import com.howudoin.backend.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController
{
    @Autowired
    private MessageRepository messageRepository;

    @PostMapping("/messages")
    public Message sendMessage(@RequestBody Message message)
    {
        message.setContent("Hello, this is a test message.");
        messageRepository.save(message);
        return messageRepository.save(message);
    }

    @GetMapping("/hello/{user}")
    public String sayHelloUser(@PathVariable String user)
    {
        return "Hello, " + user + "!";
    }

    @GetMapping("/hello")
    public String hello(@RequestBody Message message)
    {
        return "Hello, " + message.getContent() + "!";
    }
}
