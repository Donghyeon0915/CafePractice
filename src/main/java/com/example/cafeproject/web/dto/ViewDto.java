package com.example.cafeproject.web.dto;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@Builder
public class ViewDto {
    private Long articleId;
    private String userNickname;
}
