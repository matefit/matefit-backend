package io.matefit.api.controller;

import io.matefit.api.service.ArticleService;
import io.matefit.core.dto.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static io.matefit.api.response.DefaultRes.FAIL_DEFAULT_RES;

@RequestMapping("/api/article")
@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity createArticle(@RequestBody Article article) {
        try {
            return new ResponseEntity<>(articleService.createArticle(article), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity deleteArticle(@RequestBody Article article) {
        try {
            return new ResponseEntity<>(articleService.deleteArticle(article), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 조건별 필터를 적용하여 유저에 맞는 게시물을 띄워주는 기능
    @GetMapping
    public ResponseEntity filterArticle(@RequestBody Article article) {
        try {
            return new ResponseEntity<>(articleService.filterArticle(article), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 유저가 키워드를 입력하여 직접 게시물을 검색하는 기능
    @GetMapping
    public ResponseEntity searchArticle(@RequestBody Article article) {
        try {
            return new ResponseEntity<>(articleService.searchArticle(article), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}