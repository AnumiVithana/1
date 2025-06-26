package Flight_Tracker.demo.service;

import Flight_Tracker.demo.model.Airport;
import Flight_Tracker.demo.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    //Get all airports
    public List<Airport> getAllAirports(){
        return airportRepository.findAll();
    }

    //Get airport by id
    public Airport getAirport(Long id){
        return airportRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Airport not found"));
    }

    //create airport
    public Airport createAirport(Airport airport){
        return airportRepository.save(airport);
    }

    //update airport

    public Airport updateAirport(Long id, Airport updatedAirport){
        return airportRepository.findById(id)
                .map(airport->{
                    airport.setName(updatedAirport.getName());
                    airport.setCode(updatedAirport.getCode());
                    airport.setCity(updatedAirport.getCity());
                    airport.setCountry(updatedAirport.getCountry());
                    return airportRepository.save(updatedAirport);
                }).orElseThrow(()->new RuntimeException("Airline not found"));
    }

    //Delete airport
    public void deleteAirport(Long id){
        airportRepository.deleteById(id);
    }

    //filter airports by country
    public List<Airport> findByCountry(String country){
        return airportRepository.findByCountry(country);
    }
}
