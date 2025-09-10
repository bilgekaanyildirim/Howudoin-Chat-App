package com.howudoin.backend.controller;

import com.howudoin.backend.payload.ChannelDTO;
import com.howudoin.backend.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/channels/{channelId}/add-member/{userId}")
    public ResponseEntity<String> addMemberToChannel(@PathVariable Long channelId,
                                                     @PathVariable Long userId)
    {
        String message = channelService.addMemberToChannel(channelId, userId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/channels/{channelId}")
    public ResponseEntity<ChannelDTO> getChannelById(@PathVariable Long channelId)
    {
        ChannelDTO channelDTO = channelService.getChannelById(channelId);
        return new ResponseEntity<>(channelDTO, HttpStatus.OK);
    }
}
