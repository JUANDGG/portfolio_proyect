package com.domain.services.passwordHash;

import java.util.List;

import com.persistence.dto.PasswordHashDTO;

public interface  PasswordHashService {
    List<PasswordHashDTO> read ();
    void create(PasswordHashDTO passwordHashDTO);
    void update(PasswordHashDTO passwordHashDTO);
    void delete (long id);
    
}
