package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AirplaneTest {
    private Airplane airplane;

    @BeforeEach
    public void setUp()
    {
        //Since airplane is abstract, we need to mock it
        airplane=mock(Airplane.class,withSettings().defaultAnswer(CALLS_REAL_METHODS));
        //Initialize a Airplane object with valid parameters
        doCallRealMethod().when(airplane).setAirplaneID(anyInt());
        doCallRealMethod().when(airplane).setAirplaneModel(anyString());
        doCallRealMethod().when(airplane).setBusinessSitsNumber(anyInt());
        doCallRealMethod().when(airplane).setEconomySitsNumber(anyInt());
        doCallRealMethod().when(airplane).setCrewSitsNumber(anyInt());
    }



    @Test
    public void testValidAirplaneCreation()
    {
        //Test valid values for a Airplane
        assertDoesNotThrow(()->{
            airplane.setAirplaneID(1);
            airplane.setAirplaneModel("Quantas");
            airplane.setBusinessSitsNumber(10);
            airplane.setEconomySitsNumber(100);
            airplane.setCrewSitsNumber(10);
        });
    }

    @Test
    public void testAirplaneCreationWithEmptyAirplaneMode()
    {
        //Test setting an empty airplane model
        Exception e=assertThrows(IllegalArgumentException.class,()->airplane.setAirplaneModel(""));
        assertTrue(e.getMessage().contains("Airplane Model is required and cannot be empty."));
    }

    @Test
    public void testAirplaneCreationWithNullAirplaneMode()
    {
        //Test setting a null airplane model
        Exception e=assertThrows(IllegalArgumentException.class,()->airplane.setAirplaneModel(null));
        assertTrue(e.getMessage().contains("Airplane Model is required and cannot be empty."));
    }

    @Test
    public void testSeatNumberGreaterThan300()
    {
        //Test setting seat number greater than 300
        Exception e=assertThrows(IllegalArgumentException.class,()->{
            airplane.setBusinessSitsNumber(100);
            airplane.setEconomySitsNumber(500);
            airplane.setCrewSitsNumber(300);
        });
        assertTrue(e.getMessage().contains("Number of seats must be between 1 and 300"));
    }

    @Test
    public void testSeatNumberLessThan0()
    {
        //Test setting seat number less than 1
        Exception e=assertThrows(IllegalArgumentException.class,()->{
            airplane.setBusinessSitsNumber(0);
            airplane.setEconomySitsNumber(0);
            airplane.setCrewSitsNumber(0);
        });
        assertTrue(e.getMessage().contains("Number of seats must be between 1 and 300"));
    }



}