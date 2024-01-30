package com.dafo.application.controller;

import com.dafo.application.entity.Building;
import com.dafo.application.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/building")
@RestController

public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @GetMapping("/all")
    public ResponseEntity<List<Building>> getAllBuilding (){
        List<Building> buildingList = buildingService.getAll();
        return new ResponseEntity<>(buildingList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Building> getBuildingById (@PathVariable int id){
        Building buildingList = buildingService.getById(id);
        return new ResponseEntity<>(buildingList, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<Building> saveBuilding(@RequestBody Building building ){
        return new ResponseEntity<>(buildingService.save(building), HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Building> deleteBuilding(@RequestParam int id ){
        return new ResponseEntity<>(buildingService.deleteByID(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Building> updateBuilding(@RequestParam int id, @RequestBody Building building ){
        return new ResponseEntity<>(buildingService.updateByID(id, building), HttpStatus.OK);
    }
}
