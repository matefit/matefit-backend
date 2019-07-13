package io.matefit.api.controller;

import io.matefit.api.service.ArticleService;
import io.matefit.api.service.CommentService;
import io.matefit.core.dto.Article;
import io.matefit.core.dto.Comment;
import io.matefit.core.dto.DoubleComment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static io.matefit.api.response.DefaultRes.FAIL_DEFAULT_RES;

@RequestMapping("/api/article")
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity createComment(@RequestBody Comment comment) {
        try {
            return new ResponseEntity<>(commentService.createComment(comment), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity deleteComment(@RequestBody Comment comment) {
        try {
            return new ResponseEntity<>(commentService.deleteComment(comment), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping
    public ResponseEntity createDoubleComment(@RequestBody DoubleComment doubleComment) {
        try {
            return new ResponseEntity<>(commentService.createDoubleComment(doubleComment), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity deleteDoubleComment(@RequestBody DoubleComment doubleComment) {
        try {
            return new ResponseEntity<>(commentService.deleteDoubleComment(doubleComment), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}