package com.domain.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.persistence.entity.PasswordHash;

@Service
public interface PasswordHashRepository extends JpaRepository<PasswordHash,Long>{
    
}
