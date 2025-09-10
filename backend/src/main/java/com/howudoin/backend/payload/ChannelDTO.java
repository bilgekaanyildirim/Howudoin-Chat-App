package com.howudoin.backend.payload;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ChannelDTO
{
    private Long channelId;
    private String name;
    private String description;
    private List<Long> memberIds = new ArrayList<>();
    private LocalDateTime createdAt;
}
