package com.howudoin.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "channels")
public class Channel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "channel_id")
    private Long channelId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private User admin;

    private LocalDateTime createdAt;

    private String description;

    @ManyToMany
    @JoinTable(name = "channel_members",
            joinColumns = @JoinColumn(name = "channel_id", referencedColumnName = "channel_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"channel_id", "user_id"}))
    private Set<User> members;
}
