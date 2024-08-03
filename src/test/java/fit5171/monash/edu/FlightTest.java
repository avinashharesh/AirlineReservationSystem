package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FlightTest {
    private Flight flight;

    @BeforeEach
    public void setUp()
    {
        flight=mock(Flight.class,withSettings().defaultAnswer(CALLS_REAL_METHODS));

        doCallRealMethod().when(flight).setFlightID(anyInt());
        doCallRealMethod().when(flight).setDepartTo(anyString());
        doCallRealMethod().when(flight).setDepartFrom(anyString());
        doCallRealMethod().when(flight).setCode(anyString());
        doCallRealMethod().when(flight).setCompany(anyString());
        doCallRealMethod().when(flight).setDateFrom(anyString());
        doCallRealMethod().when(flight).setDateTo(anyString());


    }

    @Test
    public void testValidFlightCreation()
    {
        assertDoesNotThrow(()->{
            flight.setFlightID(1);
            flight.setDepartTo("Melbourne");
            flight.setDepartFrom("Sydney");
            flight.setCode("ABDSC");
            flight.setCompany("Quantas");
            flight.setDateFrom("23-04-2023 12:30:45");
            flight.setDateTo("29-04-2023 12:30:45");
            flight.setAirplane(new Airplane(1,"Emirates",10,100,10));

        });
    }

    @Test
    public void testFlightCreationWithEmptyDepart()
    {
        Exception e=assertThrows(IllegalArgumentException.class,()->flight.setDepartTo(""));
        assertTrue(e.getMessage().contains("Depart To must not be empty"));
    }

    @Test
    public void testFlightCreationWithNullDepart()
    {
        Exception e=assertThrows(IllegalArgumentException.class,()->flight.setDepartTo(null));
        assertTrue(e.getMessage().contains("Depart To must not be empty"));
    }

    @Test
    public void testFlightCreationWithNullAirplane()
    {
        Exception e=assertThrows(IllegalArgumentException.class,()->flight.setAirplane(null));
        assertTrue(e.getMessage().contains("Airplane must not be empty"));
    }

    @Test
    public void testInvalidDateTimeFormat()
    {
        Exception e=assertThrows(IllegalArgumentException.class,()->flight.setDateTo("2023-04-20 12:30:45"));
        assertTrue(e.getMessage().contains("Invalid date-time format"));
    }

}