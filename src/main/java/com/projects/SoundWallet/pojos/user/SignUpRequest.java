package com.projects.SoundWallet.pojos.user;

import lombok.Data;

@Data
public class SignUpRequest {

    private String name;
    private String emailAddress;
    private String password;
}
