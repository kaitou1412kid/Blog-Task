package com.kritagya.blog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "COMMENT")
public class Comment {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TEXT")
    private String text;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post postId;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User userId;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

}
