package Flight_Tracker.demo.service;

import Flight_Tracker.demo.model.Airline;
import Flight_Tracker.demo.model.Airport;
import Flight_Tracker.demo.model.Flight;
import Flight_Tracker.demo.repository.AirlineRepository;
import Flight_Tracker.demo.repository.AirportRepository;
import Flight_Tracker.demo.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    private final FlightRepository flightRepository;
    private final AirlineRepository airlineRepository;
    private final AirportRepository airportRepository;


    public FlightService(FlightRepository flightRepository, AirlineRepository airlineRepository, AirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airlineRepository = airlineRepository;
        this.airportRepository = airportRepository;
    }

    //Get all flights
    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    //Get flight by id
    public Flight getFlight(Long id){
        return flightRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Flight not found"));
    }

    //Create flight
    public Flight createFlight(Flight flight, Long airlineID, Long originID, Long destinationID){
        Airline airline = airlineRepository.findById(airlineID).orElseThrow();
        Airport origin = airportRepository.findById(originID).orElseThrow();
        Airport destination = airportRepository.findById(destinationID).orElseThrow();

        flight.setAirline(airline);
        flight.setOrigin(origin);
        flight.setDestination(destination);

        return flightRepository.save(flight);
    }

    //Update Flight
    public Flight updateFlight(Long id, Flight updatedFlight){
        return flightRepository.findById(id)
                .map(flight->{
                    flight.setFlightNumber(updatedFlight.getFlightNumber());
                    flight.setOrigin(updatedFlight.getOrigin());
                    flight.setDestination(updatedFlight.getDestination());
                    flight.setStatus(updatedFlight.getStatus());
                    return flightRepository.save(flight);
                }).orElseThrow(()->new RuntimeException("Flight not found"));
    }

    //Delete flight
    public void deleteFlight(Long id){
        flightRepository.deleteById(id);
    }
}
