package fit5171.monash.edu;

import java.math.BigDecimal;

public class Ticket {
    private int ticket_id;
    private double price;
    private Flight flight;
    private boolean classVip; // indicates if this is business class ticket or not
    private boolean status; // indicates status of ticket: if it is bought by someone or not
    private Passenger passenger;

    public Ticket() {
        // Empty constructor
    }

    public Ticket(int ticket_id, double price, Flight flight, boolean classVip,boolean ticketStatus, Passenger passenger) {
        this.ticket_id = ticket_id;
        this.price = price;
        this.flight = flight;
        this.classVip = classVip;
        this.status = false;
        this.passenger = passenger;

        applyDiscount(); // Apply discount based on age category
        applyServiceTax(); // Apply service tax to the ticket price
    }

    // Getters and Setters

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Price must be a non-negative value.");
        }
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public boolean isClassVip() {
        return classVip;
    }

    public void setClassVip(boolean classVip) {
        this.classVip = classVip;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    // Discount and Service Tax Calculation Methods

    private void applyDiscount() {
        int age = passenger.getAge();
        double discount = 0.0;

        if (age < 15) {
            discount = 0.5; // 50% discount for children under 15
        } else if (age >= 60) {
            discount = 1.0; // 100% discount for elder people
        }

        this.price -= this.price * discount;
    }

    private void applyServiceTax() {
        BigDecimal priceAfterTax = BigDecimal.valueOf(this.price * 1.12);
        this.price = priceAfterTax.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();// Rounded to 1 decimal place
        // 12% service tax
    }

    // toString Method

    @Override
    public String toString() {
        return "Ticket{" +
                "ticket_id=" + ticket_id +
                ", price=" + price +
                ", flight=" + flight.getCode() + " (" + flight.getDepartFrom() + " to " + flight.getDepartTo() + ")" +
                ", classVip=" + classVip +
                ", status=" + status +
                ", passenger=" + passenger.getFirstName() + " " + passenger.getSecondName() +
                '}';
    }
}
