package Flight_Tracker.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNumber;
    @ManyToOne
    @JoinColumn(name = "origin_airport_id")
    @JsonIgnoreProperties("flights")
    private Airport origin;

    @ManyToOne
    @JoinColumn(name = "destination_airport_id")
    @JsonIgnoreProperties("flights")
    private Airport destination;

    private String status;

    @ManyToOne
    @JoinColumn(name = "airline_id")
    @JsonIgnoreProperties("flights")
    private Airline airline;

}
