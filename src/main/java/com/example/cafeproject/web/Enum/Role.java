package com.example.cafeproject.web.Enum;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("ROLE_GUEST", "비회원"),
    USER("ROLE_USER", "회원"),
    MASTER("ROLE_MASTER", "관리자");

    private final String key;
    private final String title;
}
