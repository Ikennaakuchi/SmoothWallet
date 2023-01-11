package com.projects.SoundWallet.services.impl;

import com.projects.SoundWallet.entities.User;
import com.projects.SoundWallet.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class UserDetailsImpl implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User appUser = userRepository.findByEmailAddress(username).orElse(null);
        return new org.springframework.security.core.userdetails.User(appUser.getEmailAddress(), appUser.getPassword(),
                new ArrayList<>());
    }
}
