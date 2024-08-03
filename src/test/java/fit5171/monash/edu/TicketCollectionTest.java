package fit5171.monash.edu;

import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicketCollectionTest {
    private Ticket validTicket;
    private Flight flight;
    private Passenger passenger;

    @Before
    public void setUp() {

        // Setup Flight and Passenger with valid parameters
        flight = new Flight(123, "Sydney", "Melbourne", "ABC123", "Qantas", "03-11-2022 07:30:00", "03-11-2022 09:00:00", new Airplane());
        passenger = new Passenger("John", "Doe", 30, "Male", "john.doe@example.com", "0412345678", "A1234567", "1234-5678-9101-1121", 123);

        // Create a valid Ticket
        validTicket = new Ticket(101, 200.0, flight, true, false, passenger);

        // Clear the TicketCollection before each test
        TicketCollection.getTickets().clear();
    }

    @Test
    public void testAddValidTicket() {
        ArrayList<Ticket> ticketsToAdd = new ArrayList<>();
        ticketsToAdd.add(validTicket);
        TicketCollection.addTickets(ticketsToAdd);
        assertEquals("There should be 1 ticket in the collection", 3, TicketCollection.getTickets().size());
    }

    @Test
    public void testAddInvalidTicket() {
        Ticket invalidTicket = new Ticket(102, -100.0, null, false, false, passenger);
        ArrayList<Ticket> ticketsToAdd = new ArrayList<>();
        ticketsToAdd.add(invalidTicket);

        // Use assertThrows to capture the exception and verify the message
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TicketCollection.addTickets(ticketsToAdd);
        });

        // Check if the message on the exception is what we expect
        assertEquals("Invalid ticket detected. Ticket addition aborted.", exception.getMessage());
    }
    @Test
    public void testGetTicketByIdValid() {
        ArrayList<Ticket> ticketsToAdd = new ArrayList<>();
        ticketsToAdd.add(validTicket);
        TicketCollection.addTickets(ticketsToAdd);

        Ticket retrievedTicket = TicketCollection.getTicketById(101);
        assertNotNull("Ticket should be found", retrievedTicket);
        assertEquals("Retrieved ticket should have the correct ID", 101, retrievedTicket.getTicket_id());
    }

    @Test
    public void testGetTicketByIdInvalid() {
        ArrayList<Ticket> ticketsToAdd = new ArrayList<>();
        ticketsToAdd.add(validTicket);
        TicketCollection.addTickets(ticketsToAdd);

        Ticket retrievedTicket = TicketCollection.getTicketById(999); // Non-existing ticket ID
        assertNull("No ticket should be found", retrievedTicket);
    }
}
