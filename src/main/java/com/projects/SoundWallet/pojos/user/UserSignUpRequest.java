package com.projects.SoundWallet.pojos.user;

import lombok.Data;

@Data
public class UserSignUpRequest {

    private String name;
    private String emailAddress;
    private String password;
}
