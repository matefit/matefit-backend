package io.matefit.core.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PROTECTED가 가지는 강점을 정확히 모르겠어서 일단 편의상 PUBLIC으로 변경
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long article_id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, unique = true)
    private String content;

    @Column(nullable = false, unique = true)
    private Long account_id;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updated_at;

    @Builder
    public Article(String title, String content, Long account_id) {
        this.title = title;
        this.content = content;
        this.account_id = account_id;
    }
}
