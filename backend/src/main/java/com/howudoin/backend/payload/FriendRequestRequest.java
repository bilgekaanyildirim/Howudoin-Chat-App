package com.howudoin.backend.payload;

import com.howudoin.backend.model.FriendRequestStatus;
import com.howudoin.backend.model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FriendRequestRequest
{
    private Long senderId;
    private Long receiverId;
}
