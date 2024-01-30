package com.dafo.application.repository;


import com.dafo.application.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query(value = "SELECT u from Room u where u.building.id = :id")
    public List<Room> getRoomByBuildingId( @Param("id") int buildingId);

    @Query(value = "SELECT u from Room u where u.id = :id")
    public List<Room> getRoomById(@Param("id") int roomId);

}
