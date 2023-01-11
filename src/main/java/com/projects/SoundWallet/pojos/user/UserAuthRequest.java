package com.projects.SoundWallet.pojos.user;

import lombok.Data;

@Data
public class UserAuthRequest {

    private String emailAddress;

    private String password;
}
