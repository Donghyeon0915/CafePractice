package com.example.cafeproject.web.controller;

import com.example.cafeproject.web.dto.UserDto;
import com.example.cafeproject.web.dto.UserLoginDto;
import com.example.cafeproject.web.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {this.userService = userService;}


    @PostMapping("/user/login")
    public String login(UserLoginDto requestDto, Model model){
        //UserLoginDto requestDto = new UserLoginDto(userId,userPw, Role.USER);

        log.info("user 컨트롤러 : " + requestDto.toString());

        UserLoginDto target = userService.login(requestDto);


        model.addAttribute("userId", target.getUserId());
        model.addAttribute("userPw", target.getUserPw());

        return "/articles/articleIndex";
    }
}
