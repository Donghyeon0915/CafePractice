package com.example.cafeproject.web.repository;

import com.example.cafeproject.web.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
