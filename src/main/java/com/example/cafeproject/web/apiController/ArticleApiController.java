package com.example.cafeproject.web.apiController;


import com.example.cafeproject.web.dto.article.ArticleCreateDto;
import com.example.cafeproject.web.dto.article.ArticleDto;
import com.example.cafeproject.web.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleApiController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/api/articles/new")
    public ResponseEntity<ArticleDto> createArticle(@RequestBody ArticleCreateDto requestDto){
        ArticleDto target = articleService.create(requestDto);

        return ResponseEntity.status(HttpStatus.OK).body(target);
    }
}
