package com.example.cafeproject.web.controller;

import com.example.cafeproject.web.dto.user.UserDto;
import com.example.cafeproject.web.dto.user.UserLoginDto;
import com.example.cafeproject.web.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {this.userService = userService;}


/*    @PostMapping("/user/login")
    public String login(UserLoginDto requestDto, Model model){
        //UserLoginDto requestDto = new UserLoginDto(userId,userPw, Role.USER);

        log.info("user 컨트롤러 : " + requestDto.toString());

        UserLoginDto target = userService.login(requestDto);

        model.addAttribute("userId", target.getUserId());
        model.addAttribute("userPw", target.getUserPw());

        return "/articles/articleIndex";
    }*/

    @PostMapping("/user/login")
    public String login(UserLoginDto requestDto, RedirectAttributes redirectAttributes){
        log.info("user 컨트롤러 : " + requestDto.toString());

        UserDto target = userService.login(requestDto);

        //redirectAttributes.addFlashAttribute("userNickname", target.getNickname());
        redirectAttributes.addAttribute("userNickname", target.getNickname());

        return "redirect:/articles";
    }
}
