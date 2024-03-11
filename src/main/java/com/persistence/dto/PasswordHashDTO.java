package com.persistence.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.persistence.entity.User;

import lombok.*;
@Getter @Setter @Builder
public class PasswordHashDTO {
    private long id;
    private String hash;
    @JsonIgnore
    private boolean stateHash;
    @JsonIgnore
    private LocalDate creationDate;
    private User user;
}
