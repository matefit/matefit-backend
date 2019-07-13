//package io.matefit.api.controller;
//
//import io.matefit.api.service.CommentService;
//import io.matefit.core.dto.CommentDto;
//import io.matefit.core.dto.DoubleCommentDto;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import static io.matefit.api.response.DefaultRes.FAIL_DEFAULT_RES;
//
//@RequestMapping("/api/article")
//@RestController
//@RequiredArgsConstructor
//public class CommentController {
//
//    private final CommentService commentService;
//
//    @PostMapping
//    public ResponseEntity createComment(@RequestBody CommentDto commentDto) {
//        try {
//            return new ResponseEntity<>(commentService.createComment(commentDto), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping
//    public ResponseEntity deleteComment(@RequestBody CommentDto commentDto) {
//        try {
//            return new ResponseEntity<>(commentService.deleteComment(commentDto), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//
//    @PostMapping
//    public ResponseEntity createDoubleComment(@RequestBody DoubleCommentDto doubleCommentDto) {
//        try {
//            return new ResponseEntity<>(commentService.createDoubleComment(doubleCommentDto), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping
//    public ResponseEntity deleteDoubleComment(@RequestBody DoubleCommentDto doubleCommentDto) {
//        try {
//            return new ResponseEntity<>(commentService.deleteDoubleComment(doubleCommentDto), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//}