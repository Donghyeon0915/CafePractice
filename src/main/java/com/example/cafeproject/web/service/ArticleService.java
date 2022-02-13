package com.example.cafeproject.web.service;

import com.example.cafeproject.web.dto.article.ArticleCreateDto;
import com.example.cafeproject.web.dto.article.ArticleDto;
import com.example.cafeproject.web.entity.Article;
import com.example.cafeproject.web.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public ArticleDto create(ArticleCreateDto requestDto){
        Article article = Article.createArticle(requestDto);

        Article created = articleRepository.save(article);

        if(created == null) throw new IllegalArgumentException("게시글 등록 오류");

        return ArticleDto.createArticleDto(created);
    }

    public List<ArticleDto> getArticleList(){
        return articleRepository.findAll()
                .stream().map(article -> ArticleDto.createArticleDto(article))
                .collect(Collectors.toList());
    }
}
