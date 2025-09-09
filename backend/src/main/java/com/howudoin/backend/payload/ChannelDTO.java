package com.howudoin.backend.payload;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ChannelDTO
{
    private String name;
    private Long adminId;
    private String description;
    private List<Long> memberIds = new ArrayList<>();
}
