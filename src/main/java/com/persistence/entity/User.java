package com.persistence.entity;
import java.time.LocalDate;
import com.persistence.dto.PasswordHashDTO;
import com.persistence.dto.UserDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "user")
@Getter @Setter @Builder 
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    
    
    @Column(columnDefinition ="varchar(50)")
    private String name ;

    @Column(columnDefinition ="varchar(50)")
    private String lastName ;

    private LocalDate birthDate ;

    private String email ;

    @Column(columnDefinition ="varchar(60)")
    private String phone ;

    @Column(columnDefinition ="varchar(50)")
    private String profession ;

    private boolean stateUser ;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private PasswordHash passwordHash;

    public UserDTO entityToDto() {
        return UserDTO.builder()
            .name(this.name)
            .lastName(this.lastName)
            .birthDate(this.birthDate)
            .email(this.email)
            .phone(this.phone)
            .profession(this.profession)
            .stateUser(this.stateUser)
            .passwordHashId(this.passwordHash.getId())
            .build();
    }
    
    public static User dtoToEntity(UserDTO userDto, PasswordHashDTO passwordHashDTO) {
        if (userDto == null) {
            throw new IllegalArgumentException("userDto cannot be null");
        }
     return User.builder()
        .name(userDto.getName())
        .lastName(userDto.getLastName())
        .birthDate(userDto.getBirthDate())
        .email(userDto.getEmail())
        .phone(userDto.getPhone())
        .profession(userDto.getProfession())
        .stateUser(userDto.isStateUser())
        .build();

        
    }
}
