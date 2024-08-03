package fit5171.monash.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TicketSystemTest {

    private TicketSystem ticketSystem;


    @BeforeEach
    void setUp()
    {
        ticketSystem=new TicketSystem();

        //setting up flight collection
        FlightCollection.flights=new ArrayList<>();

        ArrayList<Flight> flights=new ArrayList<>();
        flights.add(new Flight(1,"Melbourne","Sydney","ABCD","Emirates","10-11-2023 12:30:03","10-11-2024 12:30:04",new Airplane(1,"GC43",10,100,10)));
        flights.add(new Flight(2,"Kochi","Sydney","ABCF","Quantas","11-11-2023 12:30:03","12-11-2024 12:30:04",new Airplane(2,"GC43",12,100,12)));
        flights.add(new Flight(3,"Mumbai","Kochi","ABCG","AirIndia","19-11-2023 12:30:03","14-11-2024 12:30:04",new Airplane(3,"GC44",11,100,11)));
        FlightCollection.addFlights(flights);

        //setting up ticket collection
        TicketCollection.tickets=new ArrayList<>();

        ArrayList<Ticket> tickets=new ArrayList<>();
        tickets.add(new Ticket(1,200,flights.get(0),true,true,new Passenger()));
        tickets.add(new Ticket(2,200,flights.get(1),true,true,new Passenger()));
        tickets.add(new Ticket(3,200,flights.get(2),true,true,new Passenger()));
        TicketCollection.addTickets(tickets);




    }

    @Test
    public void validTicketSystemCreation()
    {
        assertDoesNotThrow(()->{
            Passenger passenger=new Passenger("James","Wu",24,"Male","james.doe@example.com","0412345678","A123456","123456789",123);
            Flight flight=new Flight(1,"Melbourne","Sydney","ABDSC","Quantas","23-04-2023 12:30:45","29-04-2023 12:30:45",new Airplane(1,"Emirates",10,100,10));
            Ticket ticket=new Ticket(1,200,flight,false,false,passenger);
            ticketSystem=new TicketSystem(passenger,ticket,flight);

        });
    }

    @Test
    public void testValidChooseDirectFlightTicket()
    {
        ScannerWrapper scannerMock=mock(ScannerWrapper.class);
        when(scannerMock.nextInt()).thenReturn(1);
        when(scannerMock.nextLine()).thenReturn("Avinash","Haresh","avinash@gmail.com");
        ticketSystem.in=scannerMock;
        assertDoesNotThrow(()->{
            ticketSystem.chooseTicket("Sydney","Melbourne");
        });

    }

    @Test
    public void testValidChooseIndirectFlightTicket()
    {
        ScannerWrapper scannerMock=mock(ScannerWrapper.class);
        when(scannerMock.nextInt()).thenReturn(2,3);
        when(scannerMock.nextLine()).thenReturn("Avinash","Haresh","avinash@gmail.com");
        ticketSystem.in=scannerMock;
        assertDoesNotThrow(()->{
            ticketSystem.chooseTicket("Sydney","Mumbai");
        });
    }

    @Test
    public void testInvalidChooseFlight()
    {
        Exception e=assertThrows(IllegalArgumentException.class,()->ticketSystem.chooseTicket("Melbourne","Sydney"));
        assertTrue(e.getMessage().contains("There are no flights available"));
    }

    @Test
    public void testBookingBookedTickets()
    {
        ScannerWrapper scannerMock=mock(ScannerWrapper.class);
        when(scannerMock.nextInt()).thenReturn(1);
        when(scannerMock.nextLine()).thenReturn("Avinash","Haresh","avinash@gmail.com");
        when(scannerMock.nextInt()).thenReturn(1);
        ticketSystem.in=scannerMock;
        Exception e=assertThrows(IllegalArgumentException.class,()->{
            ticketSystem.chooseTicket("Sydney","Melbourne");
            ticketSystem.chooseTicket("Sydney","Melbourne");
        });
        assertTrue(e.getMessage().contains("Already Booked"));
    }

    @Test
    public void testInvalidPasserInfo()
    {
        ScannerWrapper scannerMock=mock(ScannerWrapper.class);
        when(scannerMock.nextInt()).thenReturn(1);
        when(scannerMock.nextLine()).thenReturn("","Haresh","avinash@gmail.com");
        ticketSystem.in=scannerMock;
        Exception e=assertThrows(IllegalArgumentException.class,()->{
            ticketSystem.chooseTicket("Sydney","Melbourne");
        });
        assertTrue(e.getMessage().contains("First name is required and cannot be empty."));
    }





}