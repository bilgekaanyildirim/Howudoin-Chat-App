package com.howudoin.backend.service;

import com.howudoin.backend.model.FriendRequest;
import com.howudoin.backend.payload.FriendRequestRequest;

import java.util.List;

public interface FriendRequestService
{
    String sendFriendRequest(FriendRequestRequest friendRequestRequest);

    String acceptFriendRequest(FriendRequestRequest friendRequestRequest);

    String refuseFriendRequest(FriendRequestRequest friendRequestRequest);

    List<FriendRequest> getFriendRequests();
}
