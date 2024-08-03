package fit5171.monash.edu;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class FlightCollection {

	public static ArrayList<Flight> flights;

	public static ArrayList<Flight> getFlights() {
		return flights;
	}

	public static void addFlights(ArrayList<Flight> flights) {
		validateFlights(flights);
		for(Flight flight:flights)
		{
			flight.validateRequiredField(flight.getDepartTo(),"Depart To");
			flight.validateRequiredField(flight.getDepartFrom(),"Depart From");
			flight.validateRequiredField(flight.getCode(),"Code");
			flight.validateRequiredField(flight.getCompany(),"Company");
			flight.validateRequiredField(flight.getDateFrom(),"From Date");
			flight.validateRequiredField(flight.getDateFrom(),"From Date");
			flight.validateRequiredField(flight.getDateTo(),"To Date");
			flight.validateRequiredField(flight.getAirplane());
			flight.validateDate(flight.getDateFrom());
			flight.validateDate(flight.getDateTo());

		}
		FlightCollection.flights.addAll(flights);
	}

	public static Flight getFlightInfo(String city1, String city2) {
		//display the flights where there is a direct flight from city 1 to city2
		validCity(city1);
		validCity(city2);
		for(Flight flight:flights)
		{
			String departFrom=flight.getDepartFrom();
			String departTo=flight.getDepartTo();
			if(departFrom.equals(city1) && departTo.equals(city2))
			{
				return flight;
			}
		}
		return null;
	}

	public static Flight getFlightInfo(String city) {
		//SELECT a flight where depart_to = city
		validCity(city);
		for(Flight flight:flights)
		{
			String departTo=flight.getDepartTo();
			if(departTo.equals(city))
				return flight;
		}
		return null;

	}
	public static Flight getFlightInfo(int flight_id) {
		//SELECT a flight with a particular flight id
		for (Flight flight:flights)
		{
			if(flight.getFlightID()==flight_id)
				return flight;
		}
		return null;

	}

	private static void validCity(String city)
	{
		String regex = "^[a-zA-Z]*$";

		// Compile the regular expression into a pattern
		Pattern pattern = Pattern.compile(regex);

		// Check if the string matches the pattern
		boolean isAlphabetic = pattern.matcher(city).matches();
		if(!isAlphabetic)
			throw new IllegalArgumentException("Not a valid city name");
		if(city==null || city.trim().isEmpty())
			throw new IllegalArgumentException("Not a valid city name");
	}

	private static  void validateFlights(ArrayList<Flight> flights)
	{
		if(flights==null)
			throw new IllegalArgumentException("List of flights should not be empty");
	}


}
