package com.example.cafeproject.web.dto.user;


import com.example.cafeproject.web.Enum.Role;
import com.example.cafeproject.web.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    @JsonProperty("id")
    private String userId;
    @JsonProperty("password")
    private String userPw;
    private String nickname;
    private Role ROLE = Role.USER;

    public static UserDto createUserDto(User user){
        return UserDto.builder()
                .userId(user.getUserId())
                .userPw(user.getUserPw())
                .nickname(user.getNickname())
                .ROLE(user.getROLE())
                .build();
    }
}
