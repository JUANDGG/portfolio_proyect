package com.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.persistence.entity.User;

@Repository
public interface RepositoryUser  extends JpaRepository<User ,Long>{

} 
