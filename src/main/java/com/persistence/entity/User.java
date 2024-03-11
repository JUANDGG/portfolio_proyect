package com.persistence.entity;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.persistence.dto.PasswordHashDTO;
import com.persistence.dto.UserDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<PasswordHash> passwordHash;


    public UserDTO toDTO() {
        return UserDTO.builder()
            .id(this.id) 
            .name(this.name)
            .lastName(this.lastName)
            .birthDate(this.birthDate)
            .email(this.email)
            .phone(this.phone)
            .profession(this.profession)
            .stateUser(this.stateUser)
            .passwordHashId(this.passwordHash.get(0).getId())
            .build();
    }
    public static User fromDTO(UserDTO userDto) {
        return User.builder()
            .id(userDto.getId())
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
