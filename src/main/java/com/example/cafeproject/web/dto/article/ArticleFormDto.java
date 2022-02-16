package com.example.cafeproject.web.dto.article;


import lombok.*;


@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ArticleFormDto {
    private String author;
    private String title;
    private String content;
}
