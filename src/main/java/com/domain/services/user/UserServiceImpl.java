package com.domain.services.user;

import java.util.List;
import java.util.stream.Collectors;

import com.persistence.entity.PasswordHash;
import com.persistence.entity.User ;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.domain.repository.PasswordHashRepository;
import com.domain.repository.UserRepository;
import com.persistence.dto.PasswordHashDTO;
import com.persistence.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository  userRepository ;

    @Autowired
    private PasswordHashRepository passwordHashRepository ;

    @Override
    public List<UserDTO> read() {
        List<User> user = userRepository.findAll() ;
        return user.stream()
            .map(User::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<UserDTO> create(UserDTO userDTO, PasswordHashDTO passwordHashDTO) {
        //the user is saved first
        User user = User.fromDTO(userDTO, passwordHashDTO);
        User savedUser = userRepository.save(user);
        // Convertir la entidad guardada a un DTO
        UserDTO savedUserDTO = savedUser.toDTO();


        var passwordHash = PasswordHash.fromDTO(passwordHashDTO);
        passwordHash.setUser(user);

        passwordHashRepository.save(passwordHash);


        // Devolver el DTO guardado
        return new ResponseEntity<>(savedUserDTO, HttpStatus.CREATED);
    } 

    @Override
    public ResponseEntity<Void> update(UserDTO userDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
