package com.persistence.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.persistence.entity.User;

import lombok.*;
@Getter @Setter @Builder
public class PasswordHashDTO {
    private long id;
    private String hash;
    private boolean stateHash;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;
    private User user;
}
