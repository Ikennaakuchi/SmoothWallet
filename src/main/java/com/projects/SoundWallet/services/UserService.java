package com.projects.SoundWallet.services;

import com.projects.SoundWallet.entities.User;
import com.projects.SoundWallet.pojos.ApiResponse;
import com.projects.SoundWallet.pojos.user.AuthRequest;
import com.projects.SoundWallet.pojos.user.AuthResponse;
import com.projects.SoundWallet.pojos.user.SignUpRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public User signUp(SignUpRequest request);
    AuthResponse signIn(AuthRequest loginRequest);
}
