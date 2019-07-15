package io.matefit.core.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long article_id;

    @Column(nullable = false, unique = true)
    private String content;

    @Column(nullable = false, unique = true)
    private char makeNamePublic;

    @Column(nullable = false, unique = true)
    private char makeBirthdayPublic;

    @Column(nullable = false, unique = true)
    private Date makeArticlePublicUntil;

    @Column(nullable = false, unique = true)
    private Long account_id;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updated_at;

    @Builder
    public Article(String content, char makeNamePublic, char makeBirthdayPublic, Date makeArticlePublicUntil, Long account_id) {
        this.content = content;
        this.makeNamePublic = makeNamePublic;
        this.makeBirthdayPublic = makeBirthdayPublic;
        this.makeArticlePublicUntil = makeArticlePublicUntil;
        this.account_id = account_id;
    }
}
