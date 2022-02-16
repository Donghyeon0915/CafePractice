package com.example.cafeproject.web.apiController;

import com.example.cafeproject.web.dto.CommentDto;
import com.example.cafeproject.web.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentApiController {
    private final CommentService commentService;

    public CommentApiController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto requestDto){
        CommentDto created = commentService.save(requestDto);

        return ResponseEntity.status(HttpStatus.OK).body(created);
    }

}
