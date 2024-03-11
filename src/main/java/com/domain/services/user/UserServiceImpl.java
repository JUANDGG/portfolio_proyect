package com.domain.services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.repository.PasswordHashRepository;
import com.domain.repository.UserRepository;
import com.persistence.dto.PasswordHashDTO;
import com.persistence.dto.UserDTO;
import com.persistence.entity.PasswordHash;
import com.persistence.entity.User;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordHashRepository passwordHashRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public UserDTO createUserWithPasswordHash(UserDTO userDto, PasswordHashDTO passwordHashDto) {
        // Convert DTOs to entities
        User user = User.dtoToEntity(userDto, passwordHashDto);
        PasswordHash passwordHash = PasswordHash.dtoToEntity(passwordHashDto);

        // Set the relationship
        user.setPasswordHash(passwordHash);
        passwordHash.setUser(user);

        // Save both entities in the database
        userRepository.save(user);
        passwordHashRepository.save(passwordHash);

        // Return the created user
        return user.entityToDto();
    }
}