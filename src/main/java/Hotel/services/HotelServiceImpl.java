package Hotel.services;

import Hotel.entities.Hotel;
import Hotel.entities.Room;
import Hotel.models.HotelModel;
import Hotel.models.RoomModel;
import Hotel.repositories.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(Integer id) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        return optionalHotel.orElse(null);
    }

    @Override
    public Hotel addHotelByModel(HotelModel hotelModel) {
        Hotel hotel = new Hotel();
        hotel.setName(hotelModel.name());
        hotel.setDescription(hotelModel.description());
        hotel.setAddress(hotelModel.address());
        hotel.setHasParking(hotelModel.hasParking());
        hotel.setHasWifi(hotelModel.hasWifi());
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotelByIdAndModel(Integer id, HotelModel hotelModel) {
        Hotel existingHotel = hotelRepository.findById(id).orElse(null);
        if (existingHotel != null) {
            existingHotel.setName(hotelModel.name());
            existingHotel.setDescription(hotelModel.description());
            existingHotel.setAddress(hotelModel.address());
            existingHotel.setHasParking(hotelModel.hasParking());
            existingHotel.setHasWifi(hotelModel.hasWifi());
            return hotelRepository.save(existingHotel);
        }
        return null;
    }
}