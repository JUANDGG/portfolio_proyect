package com.persistence.dto;
import lombok.*;

@Getter @Setter
public class UserWithPasswordHashDTO {
    private UserDTO UserDto;
    private PasswordHashDTO passwordHashDTO;

    public UserWithPasswordHashDTO(UserDTO UserDto, PasswordHashDTO passwordHashDTO) {
        if (UserDto == null) {
            throw new IllegalArgumentException("UserDto is required");
        }
        this.UserDto = UserDto;
        this.passwordHashDTO = passwordHashDTO;
    }
}