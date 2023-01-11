package com.projects.SoundWallet.pojos.user;

import com.projects.SoundWallet.entities.User;
import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private User user;
}
