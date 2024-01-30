package com.dafo.application.service;

import com.dafo.application.entity.Room;
import com.dafo.application.repository.BuildingRepository;
import com.dafo.application.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements IRoomService{
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private BuildingRepository buildingRepository;
    @Override
    public List<Room> getAll() {
        return null;
    }

    @Override
    public Room getById(int id) {
        return roomRepository.getRoomById(id).get(0);
    }

    @Override
    public Room save(Room room) {
        Room createRoom = roomRepository.save(room);
        return createRoom;
    }

    @Override
    public Room updateByID(int id, Room room) {
        return null;
    }

    @Override
    public Room deleteByID(int id) {
        Room foundRoom = getById(id);
        foundRoom.setOnService(false);
        roomRepository.save(foundRoom);
        return foundRoom;
    }

    public List<Room> getAllBuildingRoom(int buildingId){
        List<Room> roomList = roomRepository.getRoomByBuildingId(buildingId);
        return roomList;
    }
}
