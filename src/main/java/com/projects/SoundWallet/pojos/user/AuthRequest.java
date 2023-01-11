package com.projects.SoundWallet.pojos.user;

import lombok.Data;

@Data
public class AuthRequest {

    private String emailAddress;

    private String password;
}
