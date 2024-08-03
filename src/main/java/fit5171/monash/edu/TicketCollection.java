package fit5171.monash.edu;

import java.util.ArrayList;
import java.util.HashMap;

public class TicketCollection {

	public static ArrayList<Ticket> tickets = new ArrayList<>();

	public static ArrayList<Ticket> getTickets(){
		return new ArrayList<>(tickets);
		//Return a copy of the tickets list to prevent external modification
	}

	// Method to add a list of tickets(Database in the following assignment, but for this assignment I use a single Arraylist) to the collection.
	public static void addTickets(ArrayList<Ticket> ticketsToAdd){
		if(ticketsToAdd != null){
			for (Ticket ticket : ticketsToAdd){
				if (validateTicket(ticket)){
					tickets.add(ticket);
				}else{
					throw new IllegalArgumentException("Invalid ticket detected. Ticket addition aborted.");
				}
			}
		}
	}


	// Method to validate a ticket before adding
	private static boolean validateTicket(Ticket ticket){
		return ticket != null && ticket.getPrice() >= 0 && ticket.getFlight() != null && ticket.getPassenger() != null;
	}

	// Method to display all available tickets from the Ticket collection
	public static void displayAllTickets(){
		for (Ticket ticket : tickets){
			System.out.println(ticket.toString());
		}
	}

	public static void displayTickets(Flight flight)
	{
		for(Ticket ticket:tickets)
		{
			if(flight.getFlightID()==ticket.getFlight().getFlightID())
				System.out.println(ticket.toString());
		}
	}

	//Method to get a ticket by ID, ensuring the correct ticket is returned
	public static Ticket getTicketById(int ticketId){
		for (Ticket ticket : tickets){
			if (ticket.getTicket_id() == ticketId){
				return ticket;
			}else{
				System.out.println("No ticket for this ticket' s ID");
			}
		}
		return null; // Return null if no ticket matches the given ID
	}
}
