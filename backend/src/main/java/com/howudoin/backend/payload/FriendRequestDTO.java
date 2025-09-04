package com.howudoin.backend.payload;

import lombok.Data;

@Data
public class FriendRequestDTO
{
    private Long senderId;
    private Long receiverId;
}
