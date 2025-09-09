package com.howudoin.backend.payload;

import lombok.Data;

@Data
public class UserDTO
{
    private Long userId;
    private String username;
    private String email;
}
