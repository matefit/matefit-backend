package io.matefit.core.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class DoubleComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long double_comment_id;

    @Column(nullable = false, unique = true)
    private String content;

    // FK
    @Column(nullable = false, unique = true)
    private Long account_id;

    // FK
    @Column(nullable = false, unique = true)
    private Long comment_id;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updated_at;
}
