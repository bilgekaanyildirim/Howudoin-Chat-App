package com.howudoin.backend.controller;

import com.howudoin.backend.model.FriendRequest;
import com.howudoin.backend.payload.FriendRequestDTO;
import com.howudoin.backend.repository.FriendRequestRepository;
import com.howudoin.backend.repository.UserRepository;
import com.howudoin.backend.service.FriendRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friend-request")
public class FriendRequestController
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    FriendRequestRepository friendRequestRepository;

    @Autowired
    FriendRequestService friendRequestService;

    @PostMapping("/add")
    public ResponseEntity<String> sendFriendRequest(@RequestBody FriendRequestDTO friendRequestDTO)
    {
        String message = friendRequestService.sendFriendRequest(friendRequestDTO);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PostMapping("/accept")
    public ResponseEntity<String> acceptFriendRequest(@RequestBody FriendRequestDTO friendRequestDTO)
    {
        String message = friendRequestService.acceptFriendRequest(friendRequestDTO);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/refuse")
    public ResponseEntity<String> refuseFriendRequest(@RequestBody FriendRequestDTO friendRequestDTO)
    {
        String message = friendRequestService.refuseFriendRequest(friendRequestDTO);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FriendRequest>> getFriendRequests()
    {
        List<FriendRequest> friendRequests = friendRequestService.getFriendRequests();
        return new ResponseEntity<>(friendRequests, HttpStatus.OK);
    }
}
