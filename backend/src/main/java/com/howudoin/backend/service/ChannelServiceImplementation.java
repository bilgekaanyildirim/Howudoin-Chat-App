package com.howudoin.backend.service;

import com.howudoin.backend.model.Channel;
import com.howudoin.backend.model.User;
import com.howudoin.backend.payload.ChannelDTO;
import com.howudoin.backend.repository.ChannelRepository;
import com.howudoin.backend.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class ChannelServiceImplementation implements ChannelService
{
    @Autowired
    ChannelRepository channelRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String createChannel(ChannelDTO channelDTO)
    {
        Set<User> members = new HashSet<>();

       for (Long memberId : channelDTO.getMemberIds())
       {
              User member = userRepository.findById(memberId)
                      .orElseThrow(() -> new RuntimeException("Member user not found with ID: " + memberId));

              members.add(member);
       }
       Channel channel = new Channel();
       channel.setMembers(members);
       channel.setName(channelDTO.getName());
       channel.setDescription(channelDTO.getDescription());
       channel.setCreatedAt(LocalDateTime.now());

       channelRepository.save(channel);

       return "Channel created successfully";
    }

    @Override
    public String addMemberToChannel(Long channelId, Long groupId)
    {
        Channel channel = channelRepository.findById(channelId)
                .orElseThrow(() -> new RuntimeException("Channel not found"));

        User user = userRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        channel.getMembers().add(user);
        channelRepository.save(channel);

        return "Member added to channel successfully";
    }
}
