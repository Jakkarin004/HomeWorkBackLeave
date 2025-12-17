package com.example.backendproject.service;

import com.example.backendproject.dto.SelectRequestJoinDTO;
import com.example.backendproject.entity.LeaveBalancesEntity;
import com.example.backendproject.entity.LeaveRequestsEntity;
import com.example.backendproject.entity.LeaveTypesEntity;
import com.example.backendproject.entity.UserEntity;
import com.example.backendproject.model.DepartmentModel;
import com.example.backendproject.model.LeaveBalancesModel;
import com.example.backendproject.model.LeaveRequestModel;
import com.example.backendproject.repository.LeaveBalancesRepository;
import com.example.backendproject.repository.LeaveRequestsRepository;
import com.example.backendproject.repository.LeaveTypesRepository;
import com.example.backendproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Service
public class ManageService {

    @Autowired
    private LeaveRequestsRepository leaveRequestsRepository;

    @Autowired
    private LeaveTypesRepository leaveTypesRepository;

    @Autowired
    private LeaveBalancesRepository leaveBalancesRepository;

    @Autowired
    private UserRepository userRepository;

    public LeaveRequestsEntity save(LeaveRequestsEntity leaveRequestsEntity) {
            LeaveRequestsEntity lr = new LeaveRequestsEntity();

                lr.setUserID(leaveRequestsEntity.getUserID());
                lr.setLeaveTypeId(leaveRequestsEntity.getLeaveTypeId());
                lr.setStartDate(leaveRequestsEntity.getStartDate());
                lr.setEndDate(leaveRequestsEntity.getEndDate());
                lr.setStatus(leaveRequestsEntity.getStatus());
                lr.setReason(leaveRequestsEntity.getReason());

            return  leaveRequestsRepository.save(lr);
    }

    @Transactional
    public void updateRequestBalance(int id, String status,String comment) {
        LeaveRequestsEntity request = leaveRequestsRepository.findById(id).orElseThrow(() -> new RuntimeException("ไม่พบข้อมูล"));

        if(!"pending".equals(request.getStatus())){
            throw new RuntimeException("ใบลานี้ไม่อยู่ในสถานะรออนุมัติ");
        }

        request.setStatus(status);
        request.setReason(comment);

        if("approved".equals(status)){
            LocalDate startDate = LocalDate.parse(request.getStartDate());
            LocalDate endDate = LocalDate.parse(request.getEndDate());

            int totalDay = (int) ChronoUnit.DAYS.between(startDate,endDate)+1;
            String year = String.valueOf(LocalDate.now().getYear());

                LeaveBalancesEntity lb = leaveBalancesRepository.findByUserId_IdAndLeaveTypeId_IdAndYear(
                        request.getUserID().getId(),
                        request.getLeaveTypeId().getId(),
                        year
                ).orElseThrow(() -> new RuntimeException("ไม่พบวันลาที่เหลืออยู่"));

                if(lb.getRemainingDays() < totalDay){
                    throw new RuntimeException("วันลาเหลือไม่พอ");
                }

                lb.setRemainingDays(lb.getRemainingDays()-totalDay);
        }
    }

    public List<LeaveRequestsEntity> findUser(){
        List<LeaveRequestsEntity> reList =  leaveRequestsRepository.findAll();
        List<LeaveRequestsEntity> arrayList = new ArrayList<>();

        for (LeaveRequestsEntity leaveRequestsEntity : reList) {
            LeaveRequestsEntity lr = new LeaveRequestsEntity();

            lr.setId(leaveRequestsEntity.getId());
            lr.setUserID(leaveRequestsEntity.getUserID());
            lr.setLeaveTypeId(leaveRequestsEntity.getLeaveTypeId());
            lr.setStartDate(leaveRequestsEntity.getStartDate());
            lr.setEndDate(leaveRequestsEntity.getEndDate());
            lr.setStatus(leaveRequestsEntity.getStatus());
            lr.setReason(leaveRequestsEntity.getReason());

            arrayList.add(lr);
        }
        return arrayList;
    }

    public List<LeaveTypesEntity> findType(){
        List<LeaveTypesEntity> reList =  leaveTypesRepository.findAll();
        List<LeaveTypesEntity> arrayList = new ArrayList<>();

        for (LeaveTypesEntity leaveTypesEntity : reList) {
            LeaveTypesEntity lt = new LeaveTypesEntity();

            lt.setId(leaveTypesEntity.getId());
            lt.setName(leaveTypesEntity.getName());
            lt.setDescription(leaveTypesEntity.getDescription());
            lt.setMaxDays(leaveTypesEntity.getMaxDays());

            arrayList.add(lt);
        }
        return arrayList;
    }

    public List<LeaveBalancesModel> findBalance(){
        List<LeaveBalancesEntity> reList =  leaveBalancesRepository.findAll();
        List<LeaveBalancesModel> arrayList = new ArrayList<>();

        for (LeaveBalancesEntity leaveBalancesEntity : reList) {
            LeaveBalancesModel lr = new LeaveBalancesModel();

            lr.setId(leaveBalancesEntity.getId());
            lr.setUserId(leaveBalancesEntity.getUserId().getId());
            lr.setLeaveTypeId(leaveBalancesEntity.getLeaveTypeId().getId());
            lr.setMaxDays(leaveBalancesEntity.getLeaveTypeId().getMaxDays());
            lr.setYear(leaveBalancesEntity.getYear());
            lr.setRemainingDays(leaveBalancesEntity.getRemainingDays());

            arrayList.add(lr);
        }
        return arrayList;
    }

    public  List<LeaveRequestModel>  findRequest(){
        List<Object[]> reList =  leaveRequestsRepository.FindAllRequest();
        List<LeaveRequestModel> arrayList = new ArrayList<>();

        for (Object[] r : reList) {
            LeaveRequestModel sr = new LeaveRequestModel();

            sr.setId((Integer)r[0]);
            sr.setUserId((Integer)r[1]);
            sr.setUsername((String)r[2]);
            sr.setDepartment((String)r[3]);
            sr.setName((String)r[4]);
            sr.setStartDate((String)r[5]);
            sr.setEndDate((String)r[6]);
            sr.setStatus((String)r[7]);
            sr.setReason((String)r[8]);
            sr.setComment((String)r[9]);

            arrayList.add(sr);
        }
        return arrayList;
    }

    public  List<DepartmentModel> getDepartment(){
        List<UserEntity> reList =  userRepository.findAll();
        List<DepartmentModel> arrayList = new ArrayList<>();

        for (UserEntity userEntity : reList) {
            DepartmentModel departmentModel = new DepartmentModel();

            departmentModel.setDepartment(userEntity.getDepartment());

            arrayList.add(departmentModel);
        }
        return arrayList;

    }



}
