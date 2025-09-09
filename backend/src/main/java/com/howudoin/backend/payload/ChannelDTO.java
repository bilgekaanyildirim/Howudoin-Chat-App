package com.howudoin.backend.payload;

import com.howudoin.backend.model.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class ChannelDTO
{
    private String name;
    private UserDTO admin;
    private String description;
    private Set<UserDTO> members;
    private LocalDateTime createdAt;
}
