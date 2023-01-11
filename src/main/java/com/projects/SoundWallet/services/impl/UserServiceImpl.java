package com.projects.SoundWallet.services.impl;

import com.projects.SoundWallet.entities.User;
import com.projects.SoundWallet.enums.Status;
import com.projects.SoundWallet.pojos.ApiResponse;
import com.projects.SoundWallet.pojos.user.SignUpRequest;
import com.projects.SoundWallet.repositories.UserRepository;
import com.projects.SoundWallet.services.UserService;
import com.projects.SoundWallet.util.AppUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AppUtil app;
    @Override
    public User signUp(SignUpRequest request) {
        User newUser = app.getMapper().convertValue(request, User.class);
        newUser.setUuid(app.generateSerialNumber("usr"));
        newUser.setStatus(Status.INACTIVE);
        return userRepository.save(newUser);
    }
}
