package com.example.cafeproject.web.apiController;

import com.example.cafeproject.web.dto.comment.CommentDto;
import com.example.cafeproject.web.dto.comment.CommentUpdateDto;
import com.example.cafeproject.web.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class CommentApiController {
    private final CommentService commentService;

    public CommentApiController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/api/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto requestDto){
        CommentDto created = commentService.save(requestDto);

        return ResponseEntity.status(HttpStatus.OK).body(created);
    }

    @PatchMapping("/api/comments")
    public ResponseEntity<CommentDto> updateComment(@RequestBody CommentUpdateDto requestDto){
        log.info("요청 들어오나");
        CommentDto updated = commentService.update(requestDto);

        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @DeleteMapping("/api/comments/{commentId}")
    public ResponseEntity<CommentDto> deleteComment(@PathVariable Long commentId){
        CommentDto deleted = commentService.delete(commentId);

        return ResponseEntity.status(HttpStatus.OK).body(deleted);
    }
}
