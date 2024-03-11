package com.domain.services.passwordHash;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.domain.repository.PasswordHashRepository;
import com.persistence.dto.PasswordHashDTO;
import com.persistence.entity.PasswordHash;

@Service
public class PasswordHashServiceImpl implements PasswordHashService{

    @Autowired
    private PasswordHashRepository repositoryPasswordHash ;



    @Override
    public List<PasswordHashDTO> read() {
        List<PasswordHash> passwordHash = repositoryPasswordHash.findAll();
        return passwordHash.stream()
                .map(PasswordHash::toDTO) 
                .collect(Collectors.toList());
    }

    @Override
    public  ResponseEntity<PasswordHashDTO> create(PasswordHashDTO passwordHashDTO) {
        var passwordHash = PasswordHash.fromDTO(passwordHashDTO);
        passwordHash = repositoryPasswordHash.save(passwordHash);
        return ResponseEntity.ok(passwordHash.toDTO());
    }

    @Override
    public ResponseEntity<Void> update(PasswordHashDTO passwordHashDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

  
    
}
