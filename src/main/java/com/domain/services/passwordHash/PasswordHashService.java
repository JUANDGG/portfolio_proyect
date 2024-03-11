package com.domain.services.passwordHash;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.persistence.dto.PasswordHashDTO;

public interface  PasswordHashService {
    List<PasswordHashDTO> read ();
    ResponseEntity<PasswordHashDTO> create(PasswordHashDTO passwordHashDTO);
    ResponseEntity<Void> update(PasswordHashDTO passwordHashDTO);
    ResponseEntity<Void> delete (long id);
    
}
