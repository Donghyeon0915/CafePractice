package com.example.cafeproject.web.entity;


import com.example.cafeproject.web.Enum.Role;
import com.example.cafeproject.web.dto.UserDto;
import lombok.*;

import javax.persistence.*;


@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userId;

    @Column
    private String userPw;

    @Column
    private String nickname;
    
    /*
     * JPA로 데이터베이스에 저장할 때 Enum 값을 어떤 형태로 저장할지를 지정
     * 선언을 하지 않으면 Enum은 숫자로 저장되기 때문에 DB에서 값을 알아보기 힘들다.
     */
    @Enumerated(EnumType.STRING) 
    @Column(nullable = false)     
    private Role ROLE;

    public static User createUser(UserDto dto){
        if(dto.getUserId() != null) new IllegalArgumentException("요청 값에 id가 있습니다.");

        return User.builder()
                .userId(dto.getUserId())
                .userPw(dto.getUserPw())
                .nickname(dto.getNickname())
                .ROLE(dto.getROLE())
                .build();
    }
}
