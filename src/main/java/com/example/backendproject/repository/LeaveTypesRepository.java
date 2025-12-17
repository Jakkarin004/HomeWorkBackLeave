package com.example.backendproject.repository;

import com.example.backendproject.entity.LeaveRequestsEntity;
import com.example.backendproject.entity.LeaveTypesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveTypesRepository extends JpaRepository<LeaveTypesEntity,Integer> {
}
