package io.matefit.api.controller;

import io.matefit.api.service.ArticleService;
import io.matefit.core.dto.ArticleDto;
import io.matefit.core.dto.HashtagDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/article")
@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    // 글을 게시판에 등록하는 기능
    // 구현 끝, 테스트 필요
    @PostMapping
    public ResponseEntity createArticle(@RequestBody ArticleDto articleDto) {
        return new ResponseEntity<>(articleService.createArticle(articleDto), HttpStatus.OK);
    }

    // 메인 화면에서 필드들을 설정한 후 검색하는 기능 + 일치하는 해시 태그를 리턴 (검색 결과 화면)
    // 개발 중
    @GetMapping(path="/search")
    public ResponseEntity searchArticle(@RequestParam List<Character> HashtagList,
                                        @RequestParam(value = "location") String location,
                                        @RequestParam(value = "sex") char sex,
                                        @RequestParam(value = "roomType") char roomType) {
        return new ResponseEntity<>(articleService.searchArticle(HashtagList, location, sex, roomType), HttpStatus.OK);
    }

    // 검색 결과 창에서 해시 태그를 바꿔가며 그에 맞는 게시물을 띄워주는 기능
    @GetMapping(path = "/hashtag")
    public ResponseEntity filterArticle(@RequestBody ArticleDto articleDto) {
        return new ResponseEntity<>(articleService.filterArticle(articleDto), HttpStatus.OK);
    }

    // 삭제 기능은 구현하지 말자
//    @PutMapping
//     public ResponseEntity deleteArticle(@RequestBody ArticleDto articleDto) {
//        return new ResponseEntity<>(articleService.deleteArticle(articleDto), HttpStatus.OK);
//    }

}