package com.dafo.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="buildings")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int floorNum;
    private int classNum;
    private int builtYear;
    @Column(name = "isOnService")
    private boolean isOnService;

    @OneToMany(mappedBy = "building")

    private List<Room> roomList;

    public Building(String name, int floorNum, int classNum, int builtYear, boolean isOnService) {
        this.name = name;
        this.floorNum = floorNum;
        this.classNum = classNum;
        this.builtYear = builtYear;
        this.isOnService = isOnService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    public int getClassNum() {
        return classNum;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }

    public int getBuiltYear() {
        return builtYear;
    }

    public void setBuiltYear(int builtYear) {
        this.builtYear = builtYear;
    }

    public boolean isOnService() {
        return isOnService;
    }

    public void setOnService(boolean onService) {
        isOnService = onService;
    }

    public void update(Building building){
        this.name= building.getName();
        this.builtYear = building.getBuiltYear();
        this.floorNum = building.getFloorNum();
        this.isOnService = building.isOnService();
    }
}
