package com.persistence.dto;

import java.time.LocalDate;

import lombok.*;

@Getter @Setter @Builder
public class UserDTO {
    private long id;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String phone;
    private String profession;
    private boolean stateUser;
    private long passwordHashId;
}
