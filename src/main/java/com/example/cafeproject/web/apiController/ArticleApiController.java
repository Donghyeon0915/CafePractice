package com.example.cafeproject.web.apiController;


import com.example.cafeproject.web.dto.CommentDto;
import com.example.cafeproject.web.dto.article.ArticleFormDto;
import com.example.cafeproject.web.dto.article.ArticleDto;
import com.example.cafeproject.web.entity.Article;
import com.example.cafeproject.web.service.ArticleService;
import com.example.cafeproject.web.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ArticleApiController {

    private final ArticleService articleService;
    private final CommentService commentService;

    public ArticleApiController(ArticleService articleService, CommentService commentService) {
        this.articleService = articleService;
        this.commentService = commentService;
    }

    @PostMapping("/api/articles/new")
    public ResponseEntity<ArticleDto> createArticle(@RequestBody ArticleFormDto requestDto){
        ArticleDto created = articleService.create(requestDto);

        return ResponseEntity.status(HttpStatus.OK).body(created);
    }

    @PatchMapping("/api/articles/{articleId}/update")
    public ResponseEntity<ArticleDto> updateArticle(@PathVariable Long articleId, @RequestBody ArticleFormDto requestDto){
        ArticleDto updated = articleService.update(articleId, requestDto);
        
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @DeleteMapping("/api/articles/{articleId}/delete")
    public ResponseEntity<ArticleDto> deleteArticle(@PathVariable Long articleId){
        //게시글에 달린 댓글을 모두 삭제
        log.info("여기로 오는거 아닌가");
        List<CommentDto> commentDtos = commentService.deleteAll(articleId);

        ArticleDto deleted = articleService.delete(articleId);

        return ResponseEntity.status(HttpStatus.OK).body(deleted);
    }
}
