package com.howudoin.backend.service;

import com.howudoin.backend.payload.FriendRequestRequest;

public interface FriendRequestService
{
    String sendFriendRequest(FriendRequestRequest friendRequestRequest);

    String acceptFriendRequest(FriendRequestRequest friendRequestRequest);

    String refuseFriendRequest(FriendRequestRequest friendRequestRequest);

    String getFriendRequests();
}
