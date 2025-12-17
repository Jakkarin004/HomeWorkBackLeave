package com.example.backendproject.repository;

import com.example.backendproject.entity.LeaveBalancesEntity;
import com.example.backendproject.entity.LeaveTypesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LeaveBalancesRepository extends JpaRepository<LeaveBalancesEntity,Integer> {
    Optional<LeaveBalancesEntity> findByUserId_IdAndLeaveTypeId_IdAndYear(
            Integer userId,
            Integer leaveTypeId,
            String year
    );

}


