package com.example.cafeproject.web.service;


import com.example.cafeproject.web.dto.UserDto;
import com.example.cafeproject.web.dto.UserLoginDto;
import com.example.cafeproject.web.entity.User;
import com.example.cafeproject.web.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    //@Autowired 대신 생성자를 통해 DI
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserLoginDto login(UserLoginDto requestDto){
        log.info(requestDto.toString());
        User target = userRepository.findByUserId(requestDto.getUserId())
                .orElseThrow(()->new IllegalArgumentException("등록되지 않은 회원입니다."));

        // throw로 던져줘야함
        // userId로 target을 찾기 때문에 비밀번호만 같은지 체크하면 됨
        if(!target.getUserPw().equals(requestDto.getUserPw()))
               throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");

        return UserLoginDto.createUserLoginDto(target);
    }

    @Transactional
    public UserDto signUp(UserDto requestDto){
        // Dto를 Entity로 변환
        User newUser = User.createUser(requestDto);

        //as success을 사용하여 1,0으로 반환
        int exist = userRepository.userOverlapCheck(newUser.getUserId(), newUser.getNickname());
        
        // 유저가 존재하는 경우
        if(exist >= 1) throw new IllegalArgumentException("이미 등록 된 유저 정보입니다.");
        
        User created = userRepository.save(newUser);

        // 유저 id, nickname은 유니크 설정
        if(created == null) throw new IllegalArgumentException("회원가입 오류");

        return UserDto.createUserDto(created);
    }
}
