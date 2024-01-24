package Hotel.services;

import Hotel.entities.Room;
import Hotel.models.RoomModel;
import Hotel.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room addRoom(RoomModel roomModel) {
        Room room = new Room();
        room.setRoomNumber(roomModel.roomNumber());
        room.setCategory(roomModel.category());
        room.setSmoking(roomModel.isSmoking());
        return roomRepository.save(room);
    }
}