package com.example.backendproject.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="users",catalog="leave_system")
public class UserEntity {
    private Integer id;
    private String username;
    private String email;
    private String role;
    private String department;
    private String etc;

    public UserEntity() {
        super();
    }

    public UserEntity(Integer id, String username, String email, String role,String department ,String etc) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
        this.department = department;
        this.etc = etc;
    }


    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "department")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Column(name = "etc")
    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }
}
