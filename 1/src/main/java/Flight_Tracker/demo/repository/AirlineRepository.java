package Flight_Tracker.demo.repository;

import Flight_Tracker.demo.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirlineRepository extends JpaRepository<Airline, Long> {

    List<Airline> findByCountry(String Country);

}
