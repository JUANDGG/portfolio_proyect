package com.persistence.dto;

import java.time.LocalDate;

import com.persistence.entity.User;

import lombok.*;
@Getter @Setter @Builder
public class PasswordHashDTO {
    private long id;
    private String hash;
    private boolean stateHash;
    private LocalDate creationDate;
    private User user;
}
