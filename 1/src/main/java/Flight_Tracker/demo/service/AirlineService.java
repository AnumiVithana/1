package Flight_Tracker.demo.service;

import Flight_Tracker.demo.model.Airline;
import Flight_Tracker.demo.repository.AirlineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineService {

    private final AirlineRepository airlineRepository;

    public AirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    //Get All airlines

    public List<Airline> getAllAirlines(){
        return airlineRepository.findAll();
    }

    //Get Airline by ID
    public Optional<Airline> getAllAirlineById(Long id){
        return airlineRepository.findById(id);
    }

    //Create airline
    public Airline createAirline(Airline airline){
        return airlineRepository.save(airline);
    }

    //Update airline
    public Airline updateAirline(Long id, Airline updatedAirline){
        return airlineRepository.findById(id)
                .map(airline -> {
                    airline.setName(updatedAirline.getName());
                    airline.setCountry(updatedAirline.getCountry());
                    return airlineRepository.save(airline);
                }).orElseThrow(()->new RuntimeException("Airline not found"));
    }

    //Delete an airline
    public void deleteAirline(Long id){
        airlineRepository.deleteById(id);
    }
}
