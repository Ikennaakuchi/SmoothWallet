package com.projects.SoundWallet.controllers;

import com.projects.SoundWallet.pojos.ApiResponse;
import com.projects.SoundWallet.pojos.user.SignUpRequest;
import com.projects.SoundWallet.services.UserService;
import com.projects.SoundWallet.util.ResponseProvider;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;
    private final ResponseProvider responseProvider;

    @PostMapping("signup")
    public ResponseEntity<ApiResponse<Object>> signUp(@RequestBody SignUpRequest request){
        return responseProvider.success( userService.signUp(request));
    }
}
