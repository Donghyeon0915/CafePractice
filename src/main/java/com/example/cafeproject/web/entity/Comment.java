package com.example.cafeproject.web.entity;


import com.example.cafeproject.web.dto.comment.CommentDto;
import com.example.cafeproject.web.dto.comment.CommentUpdateDto;
import lombok.*;
import org.springframework.transaction.InvalidIsolationLevelException;

import javax.persistence.*;



@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nickname;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    public static Comment createComment(CommentDto dto, Article article){
        return Comment.builder()
                .nickname(dto.getNickname())
                .content(dto.getContent())
                .article(article)
                .build();
    }

    public void patch(CommentUpdateDto dto){
        // 요청에 ID 값이 없는 경우
        if(dto.getId() == null) throw new InvalidIsolationLevelException("댓글 수정 요청에 Id 값이 없습니다.");

        // 댓글 내용은 비어있어도 허용
        this.content = dto.getContent();

    }
}
