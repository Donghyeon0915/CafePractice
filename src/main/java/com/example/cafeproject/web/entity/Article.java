
package com.example.cafeproject.web.entity;


import com.example.cafeproject.web.dto.article.ArticleFormDto;
import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String author;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private Long view;

    @Column
    private Long likes;

    public static Article createArticle(ArticleFormDto dto){
        return Article.builder()
                .author(dto.getAuthor())
                .title(dto.getTitle())
                .content(dto.getContent())
                .view(0L)
                .likes(0L)
                .build();
    }

    public void fetch(ArticleFormDto dto){
        if(!"".equals(dto.getTitle())) this.title = dto.getTitle();
        if(!"".equals(dto.getContent())) this.content = dto.getContent();
    }
}
