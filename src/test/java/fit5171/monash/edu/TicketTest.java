package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {
    private Flight mockFlight;
    private Passenger mockPassenger;


    @BeforeEach
    void setUp() {
        // Mocking behaviors for Flight and Passenger classes
        mockFlight = new Flight(1, "Destination", "Origin", "ABC123", "Mock Airlines",
                "23-04-2023 12:30:45", "29-04-2023 12:30:45", new Airplane());


        mockPassenger = new Passenger("John", "Doe", 25, "Male",
                "john.doe@example.com", "0412345678", "AB1234567", "1234567890123456", 123);
    }

    @Test
    void testTicketCreation() {
        Ticket ticket = new Ticket(1, 200.0, mockFlight, false, true,mockPassenger);

        //Test that Ticket class receives valid information of flight and passenger
        assertNotNull(ticket);
        assertEquals(1, ticket.getTicket_id());
        // The service tax is always applied when a ticket is sold. Price After tax = 200*1.12=224
        assertEquals(224.0, ticket.getPrice());
        assertEquals(mockFlight, ticket.getFlight());
        assertFalse(ticket.isClassVip());
        assertFalse(ticket.isStatus());
        assertEquals(mockPassenger, ticket.getPassenger());
    }

    @Test
    void testPriceCalculationWithDiscount() {
        // Discount is always applied based on the age category of the passenger.
        // Passenger under 15 years old
        Passenger childPassenger = new Passenger("Child", "Passenger", 10, "Male",
                "child.passenger@example.com", "0412345678", "AB1234567", "1234567890123456", 123);

        Ticket childTicket = new Ticket(2, 100.0, mockFlight, false,true, childPassenger);
        assertEquals(56.0, childTicket.getPrice()); // 50% discount applied

        // Passenger over 60 years old
        Passenger elderPassenger = new Passenger("Elder", "Passenger", 65, "Female",
                "elder.passenger@example.com", "0412345678", "AB1234567", "1234567890123456", 123);

        Ticket elderTicket = new Ticket(3, 150.0, mockFlight, false, true,elderPassenger);
        assertEquals(0.0, elderTicket.getPrice()); // 100% discount applied
    }

    @Test
    void testPriceCalculationWithServiceTax() {
        // The service tax is always applied when a ticket is sold.
        Ticket ticket = new Ticket(4, 300.0, mockFlight, true,true, mockPassenger);
        assertEquals(336.0, ticket.getPrice()); // 12% service tax applied
    }

    @Test
    void testNegativePriceException() {
        // The price and service tax must be valid values (non-negative integers or real numbers)
        Ticket ticket = new Ticket();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> ticket.setPrice(-100.0));

        assertTrue(exception.getMessage().contains("Price must be a non-negative value."));
    }


}
