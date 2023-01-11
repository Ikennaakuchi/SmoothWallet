package com.projects.SoundWallet.services;

import com.projects.SoundWallet.pojos.ApiResponse;
import com.projects.SoundWallet.pojos.user.SignUpRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity<ApiResponse<Object>> signUp(SignUpRequest request);
}
