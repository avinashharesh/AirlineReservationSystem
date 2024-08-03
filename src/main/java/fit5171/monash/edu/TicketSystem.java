package fit5171.monash.edu;

import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class TicketSystem {

    ScannerWrapper in;
    Passenger passenger;
    Ticket ticket;
    Flight flight;

    public TicketSystem() {
        passenger = new Passenger();
        ticket = new Ticket();
        flight = new Flight();
    }

    public TicketSystem(Passenger passenger,Ticket ticket,Flight flight)
    {
        this.passenger=new Passenger(passenger.getFirstName(), passenger.getSecondName(), passenger.getAge(), passenger.getGender(), passenger.getEmail(),passenger.getPhoneNumber(),passenger.getPassport(), passenger.getCardNumber(), passenger.getSecurityCode());
        this.ticket=new Ticket(ticket.getTicket_id(),ticket.getPrice(),ticket.getFlight(), ticket.isClassVip(), ticket.isStatus(),ticket.getPassenger());
        this.flight=new Flight(flight.getFlightID(),flight.getDepartTo(),flight.getDepartFrom(),flight.getCode(),flight.getCompany(),flight.getDateFrom(),flight.getDateTo(),flight.getAirplane());

    }

    public void chooseTicket(String city1, String city2){
        validCity(city1);
        validCity(city2);
        int counter = 1;
        int idFirst = 0;
        int idSecond = 0;

        Flight flight = FlightCollection.getFlightInfo(city1, city2);

        if (flight != null) {
            TicketCollection.displayTickets(flight);

            System.out.println("\nEnter ID of ticket you want to choose:");

            int ticket_id = in.nextInt();

            // buy ticket here
            buyTicket(ticket_id);
        } else
        {
            // in case there is no direct ticket from city1 to city2
            Flight depart_to = FlightCollection.getFlightInfo(city2);
            if(depart_to==null)
                throw new IllegalArgumentException("There are no flights available");

            String connectCity = depart_to.getDepartFrom();

            Flight flightConnectingTwoCities = FlightCollection.getFlightInfo(city1, connectCity);

            if (flightConnectingTwoCities != null)
            {
                System.out.println("There is special way to go there. And it is transfer way, like above. Way №" + counter);

                TicketCollection.displayTickets(flightConnectingTwoCities);
                TicketCollection.displayTickets(depart_to);
                System.out.println("\nEnter ID of 1st ticket you want to choose:");
                int ticket_id_1 = in.nextInt();
                TicketCollection.displayTickets(flightConnectingTwoCities);
                System.out.println("\nEnter ID of 2nd ticket you want to choose:");
                int ticket_id_2 = in.nextInt();
                counter++;
                buyTicket(ticket_id_1, ticket_id_2);

            }

            if (counter == 1)
            {
                throw new IllegalArgumentException("There are no flights available");
            }
            return;
        }
    }

    public void buyTicket(int ticket_id)  {
        Ticket validTicket = TicketCollection.getTicketById(ticket_id);
        if(validTicket.isStatus()==true)
            throw new IllegalArgumentException("Already Booked");

        if (validTicket == null) {
            throw new IllegalArgumentException("Ticket does not exist");
        }

        int flight_id = validTicket.getFlight().getFlightID();

        System.out.println("Enter your First Name: ");
        String firstName = in.nextLine();
        passenger.setFirstName(firstName);
        System.out.println("Enter your Second Name: ");
        String secondName = in.nextLine();
        passenger.setSecondName(secondName);
        System.out.println("Enter your Email address: ");
        String emailAddress = in.nextLine();
        passenger.setEmail(emailAddress);
        System.out.println("Bought the Ticket! "+TicketCollection.getTicketById(ticket_id).toString());
        validTicket.setStatus(true);


        // Additional passenger details input and ticket purchasing logic here
    }

    public void buyTicket(int ticket_id_first, int ticket_id_second){
        Ticket validTicketFirst = TicketCollection.getTicketById(ticket_id_first);
        Ticket validTicketSecond = TicketCollection.getTicketById(ticket_id_second);

        if(validTicketFirst.isStatus() || validTicketSecond.isStatus())
            throw new IllegalArgumentException("Already Booked");

        if (validTicketFirst == null || validTicketSecond == null) {
            throw new IllegalArgumentException("Ticket does not exist");
        }

        int flight_id_first = validTicketFirst.getFlight().getFlightID();
        int flight_id_second = validTicketSecond.getFlight().getFlightID();

        System.out.println("Enter your First Name: ");
        String firstName = in.nextLine();
        passenger.setFirstName(firstName);
        System.out.println("Enter your Second Name: ");
        String secondName = in.nextLine();
        passenger.setSecondName(secondName);
        System.out.println("Enter your Email address: ");
        String emailAddress = in.nextLine();
        passenger.setEmail(emailAddress);
        System.out.println("Bought the tickets "+TicketCollection.getTicketById(ticket_id_first).toString()+TicketCollection.getTicketById(ticket_id_second).toString());
        validTicketFirst.setStatus(true);
        validTicketSecond.setStatus(true);

        // Additional passenger details input and ticket purchasing logic for transfer flights here
    }

    private void validCity(String city)
    {
        if(city==null || city.isEmpty())
            throw new IllegalArgumentException("City name cant be empty");
    }


}
