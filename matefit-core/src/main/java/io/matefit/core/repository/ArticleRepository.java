package io.matefit.core.repository;

import io.matefit.core.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    // 1. 검색어 이용한 검색 기능 추가
    // 2. 해시 태그 이용한 필터 기능 추가
    //
}
