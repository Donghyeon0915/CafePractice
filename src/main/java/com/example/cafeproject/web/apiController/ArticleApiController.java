package com.example.cafeproject.web.apiController;


import com.example.cafeproject.web.dto.article.ArticleFormDto;
import com.example.cafeproject.web.dto.article.ArticleDto;
import com.example.cafeproject.web.entity.Article;
import com.example.cafeproject.web.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ArticleApiController {

    @Autowired
    private ArticleService articleService;

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
        ArticleDto deleted = articleService.delete(articleId);

        return ResponseEntity.status(HttpStatus.OK).body(deleted);
    }
}
