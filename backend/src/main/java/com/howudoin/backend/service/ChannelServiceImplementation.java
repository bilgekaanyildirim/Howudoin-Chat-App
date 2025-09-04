package com.howudoin.backend.service;

import com.howudoin.backend.model.Channel;
import com.howudoin.backend.payload.ChannelDTO;
import com.howudoin.backend.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ChannelServiceImplementation implements ChannelService
{
    @Autowired
    ChannelRepository channelRepository;

    @Override
    public String createChannel(ChannelDTO channelDTO)
    {
        Channel channel = new Channel();
        channel.setName(channelDTO.getName());
        channel.setDescription(channelDTO.getDescription());
        channel.setMembers(channelDTO.getMembers());
        channel.setAdmin(channelDTO.getAdmin());
        channel.setCreatedAt(LocalDateTime.now());
        channelRepository.save(channel);
        return "Channel created successfully";
    }
}
