package com.example.cafeproject.web.dto.user;


import com.example.cafeproject.web.entity.User;
import lombok.*;

@ToString
@Getter
@Setter
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
