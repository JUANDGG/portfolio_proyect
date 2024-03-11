package com.domain.services.user;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.persistence.dto.PasswordHashDTO;
import com.persistence.dto.UserDTO;

public interface UserService {
    List<UserDTO> read ();
    ResponseEntity<UserDTO> create(UserDTO userDTO,PasswordHashDTO passwordHashDTO);
    ResponseEntity<Void> update(UserDTO userDTO);
    ResponseEntity<Void> delete (long id);
} 


