package com.example.backendproject.repository;

import com.example.backendproject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity,Integer> {
}
