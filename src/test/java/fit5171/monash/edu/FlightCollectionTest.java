package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;

class FlightCollectionTest {


    @BeforeEach
    public void setUp()
    {
        FlightCollection.flights=new ArrayList<>();
        ArrayList<Flight> flights=new ArrayList<>();
        flights.add(new Flight(1,"Melbourne","Sydney","ABCD","Emirates","10-11-2023 12:30:03","10-11-2024 12:30:04",new Airplane(1,"GC43",10,100,10)));
        flights.add(new Flight(2,"Kochi","Sydney","ABCF","Quantas","11-11-2023 12:30:03","12-11-2024 12:30:04",new Airplane(2,"GC43",12,100,12)));
        flights.add(new Flight(3,"Mumbai","Kochi","ABCG","AirIndia","19-11-2023 12:30:03","14-11-2024 12:30:04",new Airplane(3,"GC44",11,100,11)));
        FlightCollection.addFlights(flights);

    }

    @Test
    public void validFlightCollectionCreation()
    {

        assertDoesNotThrow(()->{
            ArrayList<Flight> flights=new ArrayList<>();
            flights.add(new Flight(1,"Melbourne","Sydney","ABCD","Emirates","10-11-2023 12:30:03","10-11-2024 12:30:04",new Airplane(1,"GC43",10,100,10)));
            flights.add(new Flight(2,"Kochi","Sydney","ABCF","Quantas","11-11-2023 12:30:03","12-11-2024 12:30:04",new Airplane(2,"GC43",12,100,12)));
            flights.add(new Flight(3,"Mumbai","Kochi","ABCG","AirIndia","19-11-2023 12:30:03","14-11-2024 12:30:04",new Airplane(3,"GC44",11,100,11)));
            FlightCollection.addFlights(flights);
        });

    }

    @Test
    public void invalidFlightCreation()
    {
        Exception e=assertThrows(IllegalArgumentException.class,()->{
            ArrayList<Flight> flights=new ArrayList<>();
            flights.add(new Flight(1,"","Sydney","ABCD","Emirates","10-11-2023 12:30:03","10-11-2024 12:30:04",new Airplane(1,"GC43",10,100,10)));
            flights.add(new Flight(2,"Kochi","Sydney","ABCF","Quantas","11-11-2023 12:30:03","12-11-2024 12:30:04",new Airplane(2,"GC43",12,100,12)));
            flights.add(new Flight(3,"Mumbai","Kochi","ABCG","AirIndia","19-11-2023 12:30:03","14-11-2024 12:30:04",new Airplane(3,"GC44",11,100,11)));
            FlightCollection.addFlights(flights);
        });
        assertTrue(e.getMessage().contains("Depart To must not be empty"));
    }

    @Test
    public void testValidCityGetFlights()
    {
        assertTrue(FlightCollection.getFlightInfo("Sydney","Melbourne")!=null);

    }

    @Test
    public void testInvalidCityGetFlights()
    {
        assertTrue(FlightCollection.getFlightInfo("Delhi")==null);
    }

    @Test
    public void testValidGetFlight()
    {
        assertTrue(FlightCollection.getFlightInfo(1)!=null);
    }

    @Test
    public void testInvalidGetFlight()
    {
        assertTrue(FlightCollection.getFlightInfo(100)==null);

    }

}