package Hotel.services;

import Hotel.entities.Hotel;
import Hotel.models.HotelModel;
import Hotel.repositories.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Hotel addHotelByIdAndModel(Integer id, HotelModel hotelModel) {
        Hotel hotel = new Hotel();
        hotel.setHotelId(id);
        hotel.setName(hotelModel.name());
        hotel.setDescription(hotelModel.description());
        hotel.setAddress(hotelModel.address());
        hotel.setHasParking(hotelModel.hasParking());
        hotel.setHasWifi(hotelModel.hasWifi());
        return hotelRepository.save(hotel);
    }
}