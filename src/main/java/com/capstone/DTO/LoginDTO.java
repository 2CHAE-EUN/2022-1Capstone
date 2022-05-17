package com.capstone.DTO;

import lombok.*;

import javax.validation.constraints.NotNull;

public class LoginDTO {

    @NotNull
    private String userEmail;

    @NotNull
    private String userPassword;

}
