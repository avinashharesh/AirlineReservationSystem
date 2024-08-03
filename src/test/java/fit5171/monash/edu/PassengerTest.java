package fit5171.monash.edu;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PassengerTest {


    @Test
    void testValidPassengerCreation() {
        // Testing that no exceptions are thrown with valid data
        assertDoesNotThrow(() -> new Passenger("James", "Wu", 24, "Male", "james.doe@example.com", "0412345678", "A123456", "123456789", 123));
    }

    @Test
    void testPassengerCreationWithEmptyFirstName() {
        // Testing that IllegalArgumentException is thrown when FirstName field is empty
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                new Passenger("", "Smith", 30, "Female", "zoey.doe@example.com", "0501234567", "B123456", "987654321", 987));
        assertTrue(e.getMessage().contains("First name is required and cannot be empty"));
    }

    @Test
    void testPassengerCreationWithEmptySecondName() {
        // Testing that IllegalArgumentException is thrown when SecondName field is empty
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                new Passenger("Zoey", "", 30, "Female", "zoey.doe@example.com", "0501234567", "B123456", "987654321", 987));
        assertTrue(e.getMessage().contains("Second name is required and cannot be empty"));
    }

    @Test
    void testPassengerCreationWithEmptyAge() {
        // Testing that IllegalArgumentException is thrown when age field is 0
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                new Passenger("Zoey", "Smith", 0, "Female", "zoey.doe@example.com", "0501234567", "B123456", "987654321", 987));
        assertTrue(e.getMessage().contains("Age is required and cannot be 0."));
    }

    @Test
    void testInvalidEmailThrowsException() {
        // Testing an invalid email address for triggering an exception.
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Passenger("Zoey", "Smith", 30, "Female", "invalid_email", "0501234567", "B123456", "987654321", 987));
        assertTrue(exception.getMessage().contains("Invalid email format"));
    }


    @Test
    void testEmptyEmailThrowsException() {
        // Testing an invalid email address for triggering an exception.
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Passenger("John", "Doe", 30, "Male", "", "0412345678", "A123456", "123456789", 123));
        assertTrue(exception.getMessage().contains("Invalid email format"));
    }

    @Test
    void testInvalidPhoneNumberThrowsException() {
        // Testing whether an invalid phone number format triggers an exception.
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Passenger("John", "Doe", 30, "Male", "john.doe@example.com", "1234", "A123456", "123456789", 123));
        assertTrue(exception.getMessage().contains("Invalid Australian mobile phone number"));
    }

    @Test
    void testEmptyPhoneNumberThrowsException() {
        // Testing whether an invalid phone number format triggers an exception.
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Passenger("John", "Doe", 30, "Male", "john.doe@example.com", "", "A123456", "123456789", 123));
        assertTrue(exception.getMessage().contains("Invalid Australian mobile phone number"));
    }

    @Test
    void testExcessivePassportNumberLengthThrowsException() {
        // Testing whether exceeding the length limit of a passport number triggers an exception.
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Passenger("John", "Doe", 30, "Male", "john.doe@example.com", "0412345678", "12345678910", "123456789", 123));
        assertTrue(exception.getMessage().contains("Passport number must not be more than 9 characters long"));
    }

}
