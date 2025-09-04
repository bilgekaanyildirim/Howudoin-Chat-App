package com.howudoin.backend.repository;

import com.howudoin.backend.model.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long>
{
    @Query("SELECT fr FROM FriendRequest fr WHERE " +
            "(fr.sender.userId = :senderId AND fr.receiver.userId = :receiverId) OR " +
            "(fr.sender.userId = :receiverId AND fr.receiver.userId = :senderId)")
    FriendRequest findFriendRequest(Long senderId, Long receiverId);
}
