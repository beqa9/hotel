package Hotel.controllers;

import Hotel.entities.Hotel;
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
    public Room room(@RequestBody RoomModel roomModel) {
        return roomService.addRoomByModel(roomModel);
    }
    @GetMapping("/{id}")
    public Room getRoomById(@RequestParam Integer id) {
        return roomService.getRoomById(id);
    }

    @PutMapping("/{id}/update")
    public Room updateRoom(@PathVariable Integer id, @RequestBody RoomModel roomModel) {
        return roomService.updateRoomByIdAndModel(id, roomModel);
    }
}