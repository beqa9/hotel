package Hotel.controllers;

import Hotel.entities.Room;
import Hotel.models.RoomModel;
import Hotel.services.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/everything")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @PostMapping("/add")
    public RoomModel addRoom(@RequestBody RoomModel roomModel) {
        Room addedRoom = roomService.addRoom(roomModel);
        return RoomModel.fromRoom(addedRoom);
    }
}