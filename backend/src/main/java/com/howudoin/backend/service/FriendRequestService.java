package com.howudoin.backend.service;

import com.howudoin.backend.model.FriendRequest;
import com.howudoin.backend.payload.FriendRequestDTO;

import java.util.List;

public interface FriendRequestService
{
    String sendFriendRequest(FriendRequestDTO friendRequestDTO);

    String acceptFriendRequest(FriendRequestDTO friendRequestDTO);

    String refuseFriendRequest(FriendRequestDTO friendRequestDTO);

    List<FriendRequest> getFriendRequests();
}
