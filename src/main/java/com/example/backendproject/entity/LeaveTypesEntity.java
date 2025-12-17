package com.example.backendproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="leave_types",catalog="leave_system")
public class LeaveTypesEntity {
    private Integer id;
    private String name;
    private String description;
    private Integer maxDays;

    public LeaveTypesEntity() {
        super();
    }

    public LeaveTypesEntity(Integer id, String name, String description, Integer maxDays) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.maxDays = maxDays;
    }

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "maxDays")
    public Integer getMaxDays() {
        return maxDays;
    }

    public void setMaxDays(Integer maxDays) {
        this.maxDays = maxDays;
    }
}
