package com.example.cafeproject.web.dto.comment;


import lombok.*;


@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentUpdateDto {
    private Long id;
    private String content;
}
