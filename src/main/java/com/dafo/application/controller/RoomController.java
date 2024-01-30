package com.dafo.application.controller;

import com.dafo.application.entity.Room;
import com.dafo.application.service.BuildingService;
import com.dafo.application.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;
    @GetMapping("/")

    public ResponseEntity<List<Room>> getAllBuilingRoom(
            @RequestParam(name="building_id") int buildingId
    ) {
        return new ResponseEntity<>(roomService.getAllBuildingRoom(buildingId), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Room> createRoom (@RequestBody Room room) {
        return new ResponseEntity<>(roomService.save(room), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Room> deleteRoom (@PathVariable int id) {
        return new ResponseEntity<>(roomService.deleteByID(id), HttpStatus.OK);
    }
}
