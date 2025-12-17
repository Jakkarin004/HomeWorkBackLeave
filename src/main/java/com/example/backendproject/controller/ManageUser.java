package com.example.backendproject.controller;

import com.example.backendproject.dto.SelectRequestJoinDTO;
import com.example.backendproject.entity.LeaveBalancesEntity;
import com.example.backendproject.entity.LeaveRequestsEntity;
import com.example.backendproject.entity.LeaveTypesEntity;
import com.example.backendproject.entity.UserEntity;
import com.example.backendproject.model.DepartmentModel;
import com.example.backendproject.model.LeaveBalancesModel;
import com.example.backendproject.model.LeaveRequestModel;
import com.example.backendproject.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ManageUser {

    @Autowired
    private ManageService manageService;

    @GetMapping("/check")
    public String check(){
        return "check point";
    }

    @GetMapping("/user-all")
    public List<LeaveRequestsEntity> getAll(){
        return  manageService.findUser();
    }

    @GetMapping("/type-all")
    public List<LeaveTypesEntity> getType(){
        return  manageService.findType();
    }

    @GetMapping("/request-all")
    public  List<LeaveRequestModel>  getQuest(){
        return manageService.findRequest();
    }

    @GetMapping("/balance-all")
    public  List<LeaveBalancesModel>  getBalance(){
        return manageService.findBalance();
    }

    @GetMapping("/department-user-all")
    public  List<DepartmentModel>  getDepartment(){
        return manageService.getDepartment();
    }

    @PostMapping("/request-user")
    public LeaveRequestsEntity save(@RequestBody LeaveRequestsEntity leaveRequestsEntity) {
        return manageService.save(leaveRequestsEntity);
    }

    @PutMapping("/leave-requests/{id}")
    public void updateRequestBalance(@PathVariable int id, @RequestBody Map<String,String> payload){
        String status = payload.get("status");
        String comment = payload.get("comment");
        manageService.updateRequestBalance(id,status,comment);
    }

}
