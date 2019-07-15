package io.matefit.core.repository;

import io.matefit.core.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    // 1. 해시 태그 + (지역, 성별, 룸타입)이용한 검색 기능 추가
    // 2. 검색 결과 창에서 해시 태그를 바꿔가며 조회하는 추가
}
