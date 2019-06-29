package io.matefit.api.controller;

import io.matefit.api.service.ArticleService;
import io.matefit.core.dto.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import static io.matefit.api.response.DefaultRes.FAIL_DEFAULT_RES;

@Transactional
@CrossOrigin
@RestController
@RequestMapping("/api/article")
public class ArticleController {


    @Autowired
    private ArticleService articleService;

    // 게시물 등록
    @PostMapping
    public ResponseEntity register(@RequestBody Article article) { // header, body(json), HTTP.status //
        try {
            return new ResponseEntity(articleService.createArticle(article), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}