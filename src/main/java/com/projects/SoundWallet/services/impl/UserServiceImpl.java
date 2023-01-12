package com.projects.SoundWallet.services.impl;

import com.projects.SoundWallet.entities.User;
import com.projects.SoundWallet.enums.Status;
import com.projects.SoundWallet.exceptions.AuthenticationException;
import com.projects.SoundWallet.exceptions.ValidationException;
import com.projects.SoundWallet.pojos.ApiResponse;
import com.projects.SoundWallet.pojos.user.AuthRequest;
import com.projects.SoundWallet.pojos.user.AuthResponse;
import com.projects.SoundWallet.pojos.user.SignUpRequest;
import com.projects.SoundWallet.repositories.UserRepository;
import com.projects.SoundWallet.security.JwtUtil;
import com.projects.SoundWallet.services.UserService;
import com.projects.SoundWallet.util.AppUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AppUtil app;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager auth;
    private final PasswordEncoder passwordEncoder;
    @Override
    public User signUp(SignUpRequest request) {
        boolean userExists = userRepository.existsByEmailAddress(request.getEmailAddress());

        if (userExists)
            throw new ValidationException("User already exists");
        User newUser = app.getMapper().convertValue(request, User.class);
        newUser.setUuid(app.generateSerialNumber("usr"));
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setStatus(Status.INACTIVE);
        return userRepository.save(newUser);
    }

    @Override
    public AuthResponse signIn(AuthRequest loginRequest) {
        try {
            Authentication authentication = auth.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmailAddress(), loginRequest.getPassword())
            );
            if (authentication.isAuthenticated()) {
                User user = userRepository.findByEmailAddress(loginRequest.getEmailAddress()).orElse(null);
                if (user != null) {

                    user.setLastLoginDate(new Date());
                    userRepository.save(user);

                    String accessToken=jwtUtil.generateToken(new org.springframework.security.core.userdetails.User(
                                loginRequest.getEmailAddress(), loginRequest.getPassword(), new ArrayList<>()));

                    AuthResponse loginResponse =new AuthResponse();
                    user.setPassword("*****************");
                    loginResponse.setUser(user);
                    loginResponse.setToken("Bearer "+ accessToken);
                    return loginResponse;

                } else {
                    throw new AuthenticationException("Invalid Login Credentials");
                }

            } else {
                throw new AuthenticationException("Invalid Username or Password");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new AuthenticationException(ex.getMessage());
        }
    }
}
