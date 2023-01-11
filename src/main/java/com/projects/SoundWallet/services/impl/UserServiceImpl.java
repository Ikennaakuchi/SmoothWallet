package com.projects.SoundWallet.services.impl;

import com.projects.SoundWallet.pojos.ApiResponse;
import com.projects.SoundWallet.pojos.user.SignUpRequest;
import com.projects.SoundWallet.services.UserService;
import org.springframework.http.ResponseEntity;

public class UserServiceImpl implements UserService {

    @Override
    public ResponseEntity<ApiResponse<Object>> signUp(SignUpRequest request) {
        return null;
    }
}
