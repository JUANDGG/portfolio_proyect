package com.persistence.entity;
import java.time.LocalDate;

import com.persistence.dto.PasswordHashDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "passwordHash")
@Builder
public class PasswordHash {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private long id ;
    @Getter @Setter 
    private String hash ;
    @Getter @Setter
    private boolean stateHash ;
    @Getter @Setter
    private LocalDate creationDate ;

    @OneToOne
    @JoinColumn(name = "user_id")
    @Getter @Setter
    private User user;



    public PasswordHashDTO entityToDto() {
        return PasswordHashDTO.builder()
            .hash(this.hash)
            .stateHash(this.stateHash)
            .creationDate(this.creationDate)
            .user(this.user)
            .build();
    }

    public static PasswordHash dtoToEntity(PasswordHashDTO passwordHashDTO) {
        return PasswordHash.builder()
            .hash(passwordHashDTO.getHash())
            .stateHash(passwordHashDTO.isStateHash())
            .creationDate(passwordHashDTO.getCreationDate())
            .user(passwordHashDTO.getUser())
            .build();
    }
}
