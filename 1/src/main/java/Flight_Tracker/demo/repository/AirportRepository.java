package Flight_Tracker.demo.repository;

import Flight_Tracker.demo.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, Long> {


    //custom method
    List<Airport> findByCountry(String country);
}
