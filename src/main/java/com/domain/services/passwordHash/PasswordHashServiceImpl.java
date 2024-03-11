package com.domain.services.passwordHash;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.repository.RepositoryPasswordHash;
import com.persistence.dto.PasswordHashDTO;
import com.persistence.entity.User;

@Service
public class PasswordHashServiceImpl implements PasswordHashService{

    @Autowired
    private RepositoryPasswordHash repositoryPasswordHash ;



    @Override
    public List<PasswordHashDTO> read() {
        List<User> users = repositoryPasswordHash.findAll();
        return users.stream()
                .map(PasswordHash::toDTO) // Aquí está el error
                .collect(Collectors.toList());
    }

    @Override
    public void create(PasswordHashDTO passwordHashDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public void update(PasswordHashDTO passwordHashDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
    
}
