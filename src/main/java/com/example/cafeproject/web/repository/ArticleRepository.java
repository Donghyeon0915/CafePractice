package com.example.cafeproject.web.repository;

import com.example.cafeproject.web.dto.article.ArticleDto;
import com.example.cafeproject.web.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Override
    @Query(value = "SELECT * FROM article ORDER BY id DESC", nativeQuery = true)
    List<Article> findAll();
}
