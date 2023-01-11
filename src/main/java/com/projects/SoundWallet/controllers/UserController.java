package com.projects.SoundWallet.controllers;

import com.projects.SoundWallet.pojos.ApiResponse;
import com.projects.SoundWallet.pojos.user.SignUpRequest;
import com.projects.SoundWallet.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    @PostMapping("signup")
    public ResponseEntity<ApiResponse<Object>> signUp(SignUpRequest request){
        return userService.signUp(request);
    }
}
