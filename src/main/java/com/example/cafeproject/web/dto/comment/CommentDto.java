package com.example.cafeproject.web.dto;

import com.example.cafeproject.web.entity.Article;
import com.example.cafeproject.web.entity.Comment;
import lombok.*;


@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long id;
    private Long articleId;
    private String nickname;
    private String content;

    public static CommentDto createCommentDto(Comment comment){
        return CommentDto.builder()
                .id(comment.getId())
                .articleId(comment.getArticle().getId())
                .nickname(comment.getNickname())
                .content(comment.getContent())
                .build();
    }
}
