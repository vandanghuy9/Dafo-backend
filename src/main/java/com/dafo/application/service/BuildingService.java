package com.dafo.application.service;

import com.dafo.application.entity.Building;
import com.dafo.application.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService implements IBuildingService {

    @Autowired
    private BuildingRepository buildingRepository;
    @Override
    public List<Building> getAll() {
        return buildingRepository.findAll();
    }

    @Override
    public Building getById(int id) {
        return buildingRepository.getBuildingById(id).get(0);
    }


    @Override
    public Building save(Building building) {
        Building saveds = buildingRepository.save(building);
        return saveds;
    } 

    @Override
    public Building updateByID(int id, Building updateBuilding) {
        Building foundBuilding = getById(id);
        foundBuilding.update(updateBuilding);
        buildingRepository.save(foundBuilding);
        return foundBuilding;
    }

    @Override
    public Building deleteByID(int id) {
        Building building = getById(id);
        building.setOnService(false);
        if (!building.isOnService()){
            buildingRepository.save(building);
            return building;
        }
        return null;
    }
}
