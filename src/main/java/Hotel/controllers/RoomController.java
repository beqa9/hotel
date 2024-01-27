package Hotel.controllers;

import Hotel.entities.Room;
import Hotel.models.RoomModel;
import Hotel.services.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/all")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @PostMapping("/add")
    public Room room(@RequestParam Integer id, @RequestBody RoomModel roomModel) {
        return roomService.addRoomByIdAndModel(id, roomModel);
    }
}