package com.example.cafeproject.web.apiController;


import com.example.cafeproject.web.dto.user.UserDto;
import com.example.cafeproject.web.dto.user.UserLoginDto;
import com.example.cafeproject.web.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 컨트롤러는 서비스에게 요청을 전달하고 응답을 반환
@Slf4j
@RestController
public class UserApiController {

    private final UserService userService;
    public UserApiController(UserService userService) {
        this.userService = userService;
    }

/*    @PostMapping("/api/user/login")
    public ResponseEntity<UserLoginDto> login(){

    }*/


    @PostMapping("/api/user/signup")
    public ResponseEntity<UserDto> signUpUser(@RequestBody UserDto requestDto){
        UserDto target = userService.signUp(requestDto);

        return ResponseEntity.status(HttpStatus.OK).body(target);
    }
}


