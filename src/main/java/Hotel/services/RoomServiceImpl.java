package Hotel.services;

import Hotel.entities.Room;
import Hotel.models.RoomModel;
import Hotel.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Room getRoomById(Integer id) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        return optionalRoom.orElse(null);
    }

    @Override
    public Room addRoomByModel(RoomModel roomModel) {
        Room room = new Room();
        room.setRoomNumber(roomModel.roomNumber());
        room.setCategory(roomModel.category());
        room.setCapacity(roomModel.capacity());
        room.setPrice(roomModel.price());
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoomByIdAndModel(Integer id, RoomModel roomModel) {
        Room existingRoom = roomRepository.findById(id).orElse(null);
        if (existingRoom != null) {
            existingRoom.setRoomNumber(roomModel.roomNumber());
            existingRoom.setCategory(roomModel.category());
            existingRoom.setCapacity(roomModel.capacity());
            existingRoom.setPrice(roomModel.price());
            return roomRepository.save(existingRoom);
        }
        return null;
    }
}
