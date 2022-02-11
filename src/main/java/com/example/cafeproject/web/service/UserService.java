package com.example.cafeproject.web.service;


import com.example.cafeproject.web.dto.UserDto;
import com.example.cafeproject.web.entity.User;
import com.example.cafeproject.web.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    //@Autowired 대신 생성자를 통해 DI
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto login(UserDto requestDto){
        log.info(requestDto.toString());
        User target = userRepository.findByUserId(requestDto.getUserId())
                .orElseThrow(()->new IllegalArgumentException("등록되지 않은 회원입니다."));


        // userId로 target을 찾기 때문에 비밀번호만 같은지 체크하면 됨
        if(!target.getUserPw().equals(requestDto.getUserPw()))
               new IllegalArgumentException("비밀번호가 일치하지 않습니다.");

        return UserDto.createUserDto(target);
    }

    public UserDto signUp(UserDto requestDto){
        // Dto를 Entity로 변환
        User newUser = User.createUser(requestDto);

        List<User> users = userRepository.findByUserIdOrNickname(newUser.getUserId(), newUser.getNickname());
        if(users.size() != 0) new IllegalArgumentException("");

        User created = userRepository.save(newUser);
        // 유저 id, nickname은 유니크 설정

        if(created == null) return null; //new IllegalArgumentException("유저 등록 실패");

        return UserDto.createUserDto(created);
    }
}
