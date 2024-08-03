package fit5171.monash.edu;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private Person person;

    @BeforeEach
    void setUp() {
        // Since Person is abstract, we need to mock it
        person = mock(Person.class, withSettings().defaultAnswer(CALLS_REAL_METHODS));
        // Initialize a Person object with valid parameters
        doCallRealMethod().when(person).setFirstName(anyString());
        doCallRealMethod().when(person).setSecondName(anyString());
        doCallRealMethod().when(person).setAge(anyInt());
        doCallRealMethod().when(person).setGender(anyString());
    }

    @Test
    void testValidPersonCreation() {
        // Test setting valid values for a Person
        assertDoesNotThrow(() -> {
            person.setFirstName("James");
            person.setSecondName("Wu");
            person.setAge(24);
            person.setGender("Male");
        });
    }

    @Test
    void testPersonCreationWithEmptyFirstName() {
        // Test setting an empty first name
        Exception e = assertThrows(IllegalArgumentException.class, () -> person.setFirstName(""));
        assertTrue(e.getMessage().contains("First name is required and cannot be empty"));
    }

    @Test
    void testPersonCreationWithEmptySecondName() {
        // Test setting an empty first name
        Exception e = assertThrows(IllegalArgumentException.class, () -> person.setSecondName(""));
        assertTrue(e.getMessage().contains("Second name is required and cannot be empty"));
    }

    @Test
    void testPersonCreationWithNullFirstName() {
        // Test setting a null first name
        Exception e = assertThrows(IllegalArgumentException.class, () -> person.setFirstName(null));
        assertTrue(e.getMessage().contains("First name is required and cannot be empty"));
    }

    @Test
    void testPersonCreationWithNullSecondName() {
        // Test setting a null first name
        Exception e = assertThrows(IllegalArgumentException.class, () -> person.setSecondName(null));
        assertTrue(e.getMessage().contains("Second name is required and cannot be empty"));
    }

    @Test
    void testFirstNameStartingWithNumber() {
        // Test setting a first name that starts with a number
        Exception e = assertThrows(IllegalArgumentException.class, () -> person.setFirstName("1Alice"));
        assertTrue(e.getMessage().contains("First name must start with a letter and contain only letters"));
    }

    @Test
    void testPersonCreationWithEmptyAge() {
        // Test setting an empty first name
        Exception e = assertThrows(IllegalArgumentException.class, () -> person.setAge(0));
        assertTrue(e.getMessage().contains("Age is required and cannot be 0."));
    }

    @Test
    void testInvalidGender() {
        // Test setting an invalid gender
        Exception e = assertThrows(IllegalArgumentException.class, () -> person.setGender("Alien"));
        assertTrue(e.getMessage().contains("Invalid gender"));
    }
}
