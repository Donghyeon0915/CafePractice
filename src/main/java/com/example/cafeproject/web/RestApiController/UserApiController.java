package com.example.cafeproject.web.RestApiController;


import com.example.cafeproject.web.dto.UserDto;
import com.example.cafeproject.web.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// 컨트롤러는 서비스에게 요청을 전달하고 응답을 반환
@Slf4j
@RestController
public class UserApiController {

    private final UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @PostMapping("/api/user/login")
    public ResponseEntity<UserDto> login(@RequestBody UserDto requestDto){
        UserDto target = userService.login(requestDto);
        log.info("컨트롤러 : " + target.toString());

        // 오류는 Service에서 처리가 되어서 오므로 컨트롤러에선 OK만 반환
        return ResponseEntity.status(HttpStatus.OK).body(requestDto);
    }

    @PostMapping("/api/user/signup")
    public ResponseEntity<UserDto> signUpUser(@RequestBody UserDto requestDto){
        UserDto target = userService.signUp(requestDto);


        return target != null ?
                ResponseEntity.status(HttpStatus.OK).body(target) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}


