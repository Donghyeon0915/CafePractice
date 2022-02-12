package com.example.cafeproject.web.dto;


import com.example.cafeproject.web.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.web.bind.annotation.RequestBody;

@ToString
@Getter
@AllArgsConstructor
@Builder
public class UserLoginDto {
    private String userId;
    private String userPw;

    public static UserLoginDto createUserLoginDto(User user){
        return UserLoginDto.builder()
                .userId(user.getUserId())
                .userPw(user.getUserPw())
                .build();
    }
}
