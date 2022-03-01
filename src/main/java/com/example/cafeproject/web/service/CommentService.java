package com.example.cafeproject.web.service;


import com.example.cafeproject.web.dto.comment.CommentDto;
import com.example.cafeproject.web.dto.comment.CommentUpdateDto;
import com.example.cafeproject.web.entity.Article;
import com.example.cafeproject.web.entity.Comment;
import com.example.cafeproject.web.repository.ArticleRepository;
import com.example.cafeproject.web.repository.CommentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;

    public CommentService(CommentRepository commentRepository, ArticleRepository articleRepository) {
        this.commentRepository = commentRepository;
        this.articleRepository = articleRepository;
    }

    @Transactional
    public CommentDto save(CommentDto requestDto){
        //등록할 댓글 엔티티 생성
        Article article = articleRepository.findById(requestDto.getArticleId())
                .orElseThrow(()->new IllegalArgumentException("해당 ID의 게시글이 없습니다."));

        Comment comment = Comment.createComment(requestDto, article);

        Comment created = commentRepository.save(comment);

        if(created == null) throw new IllegalArgumentException("댓글 등록 오류");

        return CommentDto.createCommentDto(created);
    }

    @Transactional
    public List<CommentDto> deleteAll(Long articleId){
        List<CommentDto> commentDtos = commentRepository.findByArticleId(articleId).stream()
                .map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList());
        // deleteAllByArticleId로 삭제가 안되는 이유 ?
        for (CommentDto comment : commentDtos) commentRepository.deleteById(comment.getId());

        return commentDtos;
    }

    @Transactional
    public CommentDto update(CommentUpdateDto requestDto){
        Comment comment = commentRepository.findById(requestDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 댓글이 없습니다."));

        comment.patch(requestDto);

        return CommentDto.createCommentDto(comment);
    }

    @Transactional
    public CommentDto delete(Long commentId){
        Comment target = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 댓글이 없습니다."));

        commentRepository.delete(target);

        return CommentDto.createCommentDto(target);
    }

    public List<CommentDto> getCommentList(Long articleId){
        return commentRepository.findByArticleId(articleId)
                .stream()
                .map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList());
    }
}
