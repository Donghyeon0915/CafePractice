package com.example.cafeproject.web.repository;

import com.example.cafeproject.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM user WHERE user_id = :userId", nativeQuery = true)
    Optional<User> findByUserId(String userId);

    @Query(value = "SELECT * FROM user WHERE nickname = :nickname", nativeQuery = true)
    Optional<User> findByNickname(String nickname);

    @Query(value = "SELECT EXISTS (SELECT * FROM user WHERE user_id = :userId AND nickname = :nickname) as success", nativeQuery = true)
    int userOverlapCheck(String userId, String nickname);

}
