package com.howudoin.backend.service;

import com.howudoin.backend.configuration.FriendRequestConstants;
import com.howudoin.backend.model.FriendRequest;
import com.howudoin.backend.model.FriendRequestStatus;
import com.howudoin.backend.model.Friendship;
import com.howudoin.backend.model.User;
import com.howudoin.backend.payload.FriendRequestDTO;
import com.howudoin.backend.repository.FriendRequestRepository;
import com.howudoin.backend.repository.FriendshipRepository;
import com.howudoin.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FriendRequestImplementation implements FriendRequestService
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    FriendRequestRepository friendRequestRepository;

    @Autowired
    FriendshipRepository friendshipRepository;

    @Override
    public String sendFriendRequest(FriendRequestDTO friendRequestDTO)
    {

        User receiver = userRepository.findById(friendRequestDTO.getReceiverId())
                .orElseThrow(() -> new RuntimeException("Error: User not found."));

        User sender = userRepository.findById(friendRequestDTO.getSenderId())
                .orElseThrow(() -> new RuntimeException("Error: User not found."));

        FriendRequest friendRequest = friendRequestRepository.findFriendRequest(sender.getUserId(), receiver.getUserId());

        if (friendRequest != null)
        {
            if (friendRequest.getStatus() == FriendRequestStatus.PENDING)
            {
                return "Friend request is already pending.";
            }
            else if (friendRequest.getStatus() == FriendRequestStatus.ACCEPTED)
            {
                return "You are already friends.";
            }
            else if (friendRequest.getStatus() == FriendRequestStatus.REFUSED)
            {
                if (friendRequest.getCreatedAt().getYear() < LocalDateTime.now().plusYears(FriendRequestConstants.FRIENDREQUEST_RESEND_YEAR_TIME).getYear())
                {
                    friendRequest.setStatus(FriendRequestStatus.PENDING);
                    friendRequest.setCreatedAt(LocalDateTime.now());
                    friendRequestRepository.save(friendRequest);
                    return "Friend request sent successfully.";
                }
                else
                {
                    LocalDateTime allowedResendDate = friendRequest.getCreatedAt().plusYears(FriendRequestConstants.FRIENDREQUEST_RESEND_YEAR_TIME);
                    Duration duration = Duration.between(LocalDateTime.now(), allowedResendDate);
                    long daysLeft = duration.toDays();
                    return "You can resend the friend request after " + daysLeft + " day(s) from the last refusal.";
                }
            }
        }

        friendRequest = new FriendRequest();
        friendRequest.setSender(sender);
        friendRequest.setReceiver(receiver);
        friendRequest.setStatus(FriendRequestStatus.PENDING);
        friendRequest.setCreatedAt(LocalDateTime.now());
        friendRequestRepository.save(friendRequest);

        return "Friend request sent successfully.";
    }

    @Override
    public String acceptFriendRequest(FriendRequestDTO friendRequestDTO)
    {
        User receiver = userRepository.findById(friendRequestDTO.getReceiverId())
                .orElseThrow(() -> new RuntimeException("Error: User not found."));

        User sender = userRepository.findById(friendRequestDTO.getSenderId())
                .orElseThrow(() -> new RuntimeException("Error: User not found."));

        FriendRequest friendRequest = friendRequestRepository.findFriendRequest(sender.getUserId(), receiver.getUserId());

        if (friendRequest == null || friendRequest.getStatus() != FriendRequestStatus.PENDING)
        {
            return "No pending friend request found.";
        }

        LocalDateTime now = LocalDateTime.now();

        Friendship friendship = new Friendship();
        friendship.setUser1(sender);
        friendship.setUser2(receiver);
        friendship.setCreatedAt(now);
        friendshipRepository.save(friendship);

        friendRequest.setStatus(FriendRequestStatus.ACCEPTED);
        friendRequest.setCreatedAt(now);
        friendRequestRepository.save(friendRequest);

        return "Friend request accepted successfully.";
    }

    @Override
    public String refuseFriendRequest(FriendRequestDTO friendRequestDTO)
    {
        User receiver = userRepository.findById(friendRequestDTO.getReceiverId())
                .orElseThrow(() -> new RuntimeException("Error: User not found."));

        User sender = userRepository.findById(friendRequestDTO.getSenderId())
                .orElseThrow(() -> new RuntimeException("Error: User not found."));

        FriendRequest friendRequest = friendRequestRepository.findFriendRequest(sender.getUserId(), receiver.getUserId());

        if (friendRequest == null || friendRequest.getStatus() != FriendRequestStatus.PENDING)
        {
            return "No pending friend request found.";
        }

        friendRequest.setStatus(FriendRequestStatus.REFUSED);
        friendRequest.setCreatedAt(LocalDateTime.now());
        friendRequestRepository.save(friendRequest);

        return "Friend request refused successfully.";
    }

    @Override
    public List<FriendRequest> getFriendRequests()
    {
        List<FriendRequest> friendRequests = friendRequestRepository.findFriendRequestsById(1L);
        return friendRequests;
    }
}
