package com.howudoin.backend.repository;

import com.howudoin.backend.model.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long>
{
}
