
package com.example.cafeproject.web.entity;


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

    @ManyToOne
    @JoinColumn(name = "user_nickname")
    private User user;
}
