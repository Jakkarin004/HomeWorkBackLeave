package com.example.backendproject.repository;

import com.example.backendproject.entity.LeaveRequestsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LeaveRequestsRepository extends JpaRepository<LeaveRequestsEntity,Integer> {
//    @Query("select lr " +
//            "from LeaveRequestsEntity lr \n" +
//            "join fetch lr.leaveTypeId lt \n")

    @Query("select lr.id ,u.id , u.username, u.department ,lt.name ,lr.startDate ,lr.endDate ,lr.status ,lr.reason,lr.comment  \n" +
            "from LeaveRequestsEntity lr \n" +
            "join lr.leaveTypeId lt \n" +
            "join lr.userID u \n")
    public  List<Object[]>  FindAllRequest();

//    @Modifying
//    @Transactional
//    @Query("update LeaveRequestsEntity lr set lr.status = :status, lr.comment = :comment where lr.id = :id")
//    int changeStatus(@Param("id") int id, @Param("status") String status,@Param("comment") String comment);
}
