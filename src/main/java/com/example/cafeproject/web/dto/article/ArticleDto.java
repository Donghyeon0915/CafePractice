package com.example.cafeproject.web.dto.article;


import com.example.cafeproject.web.entity.Article;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
    private Long id;
    private String author;
    private String title;
    private String content;
    private Long view;
    private Long likes;

    public static ArticleDto createArticleDto(Article article){
        return ArticleDto.builder()
                .id(article.getId())
                .author(article.getAuthor())
                .title(article.getTitle())
                .content(article.getContent())
                .view(article.getView())
                .likes(article.getLikes())
                .build();
    }
}
