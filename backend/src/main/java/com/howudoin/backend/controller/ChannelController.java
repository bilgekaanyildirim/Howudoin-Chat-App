package com.howudoin.backend.controller;

import com.howudoin.backend.payload.ChannelDTO;
import com.howudoin.backend.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChannelController
{
    @Autowired
    ChannelService channelService;

    @PostMapping("/channels/create")
    public ResponseEntity<String> createChannel(@RequestBody ChannelDTO channelDTO)
    {
        String message = channelService.createChannel(channelDTO);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
}
