package com.example.cafeproject.web.controller;

import com.example.cafeproject.web.dto.user.UserDto;
import com.example.cafeproject.web.dto.user.UserLoginDto;
import com.example.cafeproject.web.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {this.userService = userService;}
    
    @PostMapping("/user/login")
    public String login(UserLoginDto requestDto, HttpServletResponse response){
        log.info("user 컨트롤러 : " + requestDto.toString());

        UserDto target = userService.login(requestDto);

        Cookie userCookie = new Cookie("loginUser", target.getNickname());
        userCookie.setPath("/");
        response.addCookie(userCookie);

        return "redirect:/articles";
    }
    @GetMapping("/logout")
    public String logout(HttpServletResponse response){
        expireCookie(response, "loginUser");

        return "redirect:/";
    }

    private void expireCookie(HttpServletResponse response, String userCookie){
        Cookie cookie = new Cookie(userCookie, null);  //기존의 userCookie를 값이 null인 쿠키로 덮어씌움
        cookie.setMaxAge(0); // 쿠키 유효 시간을 0으로 설정
        response.addCookie(cookie);
    }
}
