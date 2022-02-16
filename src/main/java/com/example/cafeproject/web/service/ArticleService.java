package com.example.cafeproject.web.service;

import com.example.cafeproject.web.dto.article.ArticleFormDto;
import com.example.cafeproject.web.dto.article.ArticleDto;
import com.example.cafeproject.web.entity.Article;
import com.example.cafeproject.web.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<ArticleDto> getArticleList(){
        return articleRepository.findAll()
                .stream().map(article -> ArticleDto.createArticleDto(article))
                .collect(Collectors.toList());
    }

    public ArticleDto getArticle(Long articleId){
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

        return ArticleDto.createArticleDto(article);
    }


    @Transactional
    public ArticleDto create(ArticleFormDto requestDto){
        Article article = Article.createArticle(requestDto);

        Article created = articleRepository.save(article);

        if(created == null) throw new IllegalArgumentException("게시글 등록 오류");

        return ArticleDto.createArticleDto(created);
    }

    @Transactional
    public ArticleDto update(Long articleId, ArticleFormDto requestDto){
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 게시글이 존재하지 않습니다."));

        //Article updated = articleRepository.save(article);
        //if(updated == null) throw new IllegalArgumentException("게시글 업데이트 오류");
        article.patch(requestDto);  //JPA 영속성 컨텍스트로 인해 Repository로 save하지 않아도 update 쿼리가 전송됨

        return ArticleDto.createArticleDto(article);
    }

    @Transactional
    public ArticleDto delete(Long articleId){
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 게시글이 존재하지 않습니다."));

        articleRepository.delete(article);

        return ArticleDto.createArticleDto(article);
    }
}
