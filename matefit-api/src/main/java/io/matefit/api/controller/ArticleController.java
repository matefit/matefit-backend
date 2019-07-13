//package io.matefit.api.controller;
//
//import io.matefit.api.service.ArticleService;
//import io.matefit.core.dto.ArticleDto;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//
//@RequestMapping("/api/article")
//@RestController
//@RequiredArgsConstructor
//public class ArticleController {
//
//    private final ArticleService articleService;
//
//    @PostMapping
//    public ResponseEntity createArticle(@RequestBody ArticleDto articleDto) {
//        return new ResponseEntity<>(articleService.createArticle(articleDto), HttpStatus.OK);
//    }
//
//    // 유저가 키워드를 입력하여 직접 게시물을 검색하는 기능
//    @GetMapping
//    public ResponseEntity searchArticle(@RequestBody ArticleDto articleDto) {
//        return new ResponseEntity<>(articleService.searchArticle(articleDto), HttpStatus.OK);
//    }
//
//
//    // 조건별 필터를 적용하여 유저에 맞는 게시물을 띄워주는 기능
//    @GetMapping
//    public ResponseEntity filterArticle(@RequestBody ArticleDto articleDto) {
//        return new ResponseEntity<>(articleService.filterArticle(articleDto), HttpStatus.OK);
//    }
//
//    // 삭제 기능은 구현하지 말자
////    @PutMapping
////     public ResponseEntity deleteArticle(@RequestBody ArticleDto articleDto) {
////        return new ResponseEntity<>(articleService.deleteArticle(articleDto), HttpStatus.OK);
////    }
//
//}