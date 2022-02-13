package com.example.cafeproject.web.entity;


import lombok.*;

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
}
