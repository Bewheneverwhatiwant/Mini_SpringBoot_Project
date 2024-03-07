package com.dogether.dogether_back.controller;

import com.dogether.dogether_back.domain.dto.LogInDTO;
import com.dogether.dogether_back.domain.dto.SignUpDTO;
import com.dogether.dogether_back.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users") // api/users/signup 이렇게 길게 적을 필요없이, api/signup 이렇게만 적어도 되게 한다
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody SignUpDTO signupReqDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.createUser(signupReqDto));
    }

    @PostMapping("/login")
    public ResponseEntity<?> checkUser(@RequestBody LogInDTO loginReqDto)  {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.checkUser(loginReqDto));
    }

}
