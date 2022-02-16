
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

    public void patch(ArticleFormDto dto){
        // 제목은 비어있으면 안됨
        if(!"".equals(dto.getTitle())) this.title = dto.getTitle();
        // 내용은 비어있어도 허용
        this.content = dto.getContent();
    }
}
