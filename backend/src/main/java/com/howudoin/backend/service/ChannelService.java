package com.howudoin.backend.service;

import com.howudoin.backend.payload.ChannelDTO;

public interface ChannelService
{
    String createChannel(ChannelDTO channelDTO);

    String addMemberToChannel(Long channelId, Long groupId);
}
