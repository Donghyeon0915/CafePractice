package com.example.cafeproject.web.entity;


import lombok.*;

import javax.persistence.*;


@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
}
