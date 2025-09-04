package com.howudoin.backend.payload;

import com.howudoin.backend.model.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class ChannelDTO
{
    private String name;
    private User admin;
    private String description;
    private Set<User> members;
    private LocalDateTime createdAt;
}
