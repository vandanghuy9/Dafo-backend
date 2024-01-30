package com.dafo.application.repository;

import com.dafo.application.entity.Building;
import com.dafo.application.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer> {
    @Query(value = "SELECT u from Building u where u.id = :id")
    public List<Building> getBuildingById(@Param("id") int buildingId);
}
