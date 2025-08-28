package com.howudoin.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupId;

    private String groupName;

    private String description;

    private String groupImageUrl;

    @ManyToOne
    private User admin;

    private LocalDateTime createdAt;

    @ManyToMany
    private List<User> members;
}
