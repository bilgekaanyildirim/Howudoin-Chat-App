package com.howudoin.backend.service;

import com.howudoin.backend.model.Channel;
import com.howudoin.backend.model.User;
import com.howudoin.backend.payload.ChannelDTO;
import com.howudoin.backend.repository.ChannelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ChannelServiceImplementation implements ChannelService
{
    @Autowired
    ChannelRepository channelRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public String createChannel(ChannelDTO channelDTO)
    {
        Channel channel = new Channel();
        channel = modelMapper.map(channelDTO, Channel.class);

        Set<User> members = channelDTO.getMembers().stream()
                .map(userDTO -> modelMapper.map(userDTO, User.class))
                .collect(Collectors.toSet());
        channel.setMembers(members);

        channel.setCreatedAt(LocalDateTime.now());

        channelRepository.save(channel);
        return "Channel created successfully";
    }
}
