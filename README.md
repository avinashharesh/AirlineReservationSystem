# AirReserve

## Project Overview

This project involves the development of an Airline Reservation System designed to automate the process of booking flights online. The system comprises several key components, including Airplane, Flight, Person, Passenger, Ticket, TicketSystem, and TicketCollections. The implementation ensures efficient management of flight bookings, ticket availability, and user information.

## Features

- **Airplane Management**: Handles details related to aircraft, including seat configurations and validations.
- **Flight Scheduling**: Manages the scheduling and availability of flights.
- **Passenger Management**: Maintains information about individuals who book flights.
- **Ticket Management**: Concerned with booking, availability, and pricing of tickets.
- **Collections Management**: Provides functionality to manage groups of objects like flights and tickets.

## Continuous Integration and Continuous Deployment (CI/CD) Pipeline

The project utilizes a CI/CD pipeline to automate testing and deployment processes. The pipeline includes the following stages:

1. **Source Code Management**: Managed using Git for version control.
2. **Build**: Automated build process using Maven to handle dependencies, builds, and test execution.
3. **Testing**: 
   - **Unit Testing**: Each component is tested in isolation using JUnit.
   - **Integration Testing**: Verifies interactions between different components.
   - **Validation Testing**: Ensures data integrity and compliance with defined rules.
4. **Deployment**: Automated deployment process to ensure the latest version is always available.

## Testing Objectives

- **Functionality Verification**: Ensure all components operate according to the specified functional requirements.
- **Error Handling**: Validate that the system correctly handles invalid inputs and displays appropriate error messages.
- **Data Integrity**: Check that data is correctly stored, retrieved, and updated.
- **User Interface Consistency**: Confirm that the user interface is consistent and meets usability standards.

## Scope of Testing

- **Unit Testing**: Tests individual components (classes or methods) in isolation using mocking frameworks like Mockito.
- **Integration Testing**: Verifies correct interaction between components, focusing on data flow and dependency handling.
- **Validation Testing**: Ensures specific attributes adhere to defined rules, such as seat number ranges and data formats.

## Approach

- **Boundary Value Testing (BVT)**: Applied to validate seat number ranges for airplanes.
- **Equivalence Class Testing (ECT)**: Applied to validate name formats for passengers.

### Tools Used

- **JUnit**: For writing and executing unit tests.
- **Mockito**: For mocking dependencies and simulating system interactions.

## Test Plan

### Task Allocation

- **Avinash Chemmany**: Responsible for extending and testing the code for Flight, FlightCollection, Airplane, and TicketSystem classes.
- **Xuanhui Wu**: Responsible for extending and testing the code for Person, Passenger, Ticket, and TicketCollection classes.

### Test Environment

- **IDE**: IntelliJ IDEA for writing, executing, and debugging tests.
- **Project Management**: Managed using Maven.
- **Testing Framework**: JUnit for unit testing.
- **Mocking Framework**: Mockito for isolated component testing.

## System Overview

The Airline Reservation System includes several key components:

- **Airplane**: Manages aircraft details, including seat configurations.
- **Flight**: Handles flight scheduling and availability.
- **Person and Passenger**: Manages individual information for flight bookings.
- **Ticket and TicketSystem**: Concerned with ticket booking, availability, and pricing.
- **TicketCollections**: Manages groups of flights and tickets, providing functionality to add, retrieve, and validate entries.

## Testing Procedure

| Test ID             | Test Name                        | Input                  | Expected Output    | Actual Output     | Status       |
|---------------------|----------------------------------|------------------------|--------------------|-------------------|--------------|
| AirplaneTest_1      | testValidAirplaneCreation        | Valid value            | DoesNotThrow       | DoesNotThrow      | Pass         |
| AirplaneTest_2      | testAirplaneCreationWithEmptyModel | Empty model          | Throw exception    | Throw exception   | Pass         |
| AirplaneTest_3      | testAirplaneCreationWithNullModel | Null model           | Throw exception    | Throw exception   | Pass         |
| AirplaneTest_4      | testSeatNumberGreaterThan300     | Seat number > 300      | Throw exception    | Throw exception   | Pass         |
| AirplaneTest_5      | testSeatNumberLessThan0          | Seat number < 1        | Throw exception    | Throw exception   | Pass         |
| FlightCollectionTest_1 | validFlightCollectionCreation  | Valid value            | DoesNotThrow       | DoesNotThrow      | Pass         |
| FlightCollectionTest_2 | invalidFlightCreation          | Invalid flight         | Throw exception    | Throw exception   | Pass         |
| FlightCollectionTest_3 | testValidCityGetFlights        | Valid city             | Get Flight info    | Get Flight info   | Pass         |
| FlightCollectionTest_4 | testInvalidCityGetFlights      | Invalid city           | Throw exception    | Throw exception   | Pass         |
| FlightCollectionTest_5 | testValidGetFlight             | Valid flight           | Get Flight info    | Get Flight info   | Pass         |
| FlightCollectionTest_6 | testInvalidGetFlight           | Invalid flight         | Throw exception    | Throw exception   | Pass         |
| FlightTest_1        | testValidFlightCreation          | Valid flight           | DoesNotThrow       | DoesNotThrow      | Pass         |
| FlightTest_2        | testFlightCreationWithEmptyDepart | Empty depart          | Throw exception    | Throw exception   | Pass         |
| FlightTest_3        | testFlightCreationWithNullDepart | Null depart           | Throw exception    | Throw exception   | Pass         |
| FlightTest_4        | testFlightCreationWithNullAirplane | Null airplane         | Throw exception    | Throw exception   | Pass         |
| FlightTest_5        | testInvalidDateTimeFormat        | Invalid date/time format | Throw exception  | Throw exception   | Pass         |
| Passenger_1         | testValidPassengerCreation       | Valid passenger        | DoesNotThrow       | DoesNotThrow      | Pass         |
| Passenger_2         | testPassengerCreationWithEmptyFirstName | Empty first name | Throw exception    | Throw exception   | Pass         |
| Passenger_3         | testPassengerCreationWithEmptySecondName | Empty second name | Throw exception    | Throw exception   | Pass         |
| Passenger_4         | testInvalidEmailThrowsException  | Empty email            | Throw exception    | Throw exception   | Pass         |
| Passenger_5         | testInvalidPhoneNumberThrowsException | Empty phone number | Throw exception    | Throw exception   | Pass         |
| Passenger_6         | testExcessivePassportNumberLengthThrowsException | Excessive length | Throw exception | Throw exception   | Pass         |
| PersonTest_1        | testValidPersonCreation          | Valid values           | DoesNotThrow       | DoesNotThrow      | Pass         |
| PersonTest_2        | testPersonCreationWithEmptyFirstName | Empty first name     | Throw exception    | Throw exception   | Pass         |
| PersonTest_3        | testPersonCreationWithEmptySecondName | Empty second name   | Throw exception    | Throw exception   | Pass         |
| PersonTest_4        | testPersonCreationWithNullFirstName | Null first name      | Throw exception    | Throw exception   | Pass         |
| PersonTest_5        | testPersonCreationWithNullSecondName | Null second name    | Throw exception    | Throw exception   | Pass         |
| PersonTest_6        | testFirstNameStartingWithNumber  | Starting with number   | Throw exception    | Throw exception   | Pass         |
| PersonTest_7        | testPersonCreationWithEmptyAge   | Empty age              | Throw exception    | Throw exception   | Pass         |
| PersonTest_8        | testInvalidGender                | Invalid gender         | Throw exception    | Throw exception   | Pass         |
| TicketCollectionTest_1 | testAddValidTicket            | Valid ticket           | DoesNotThrow       | DoesNotThrow      | Pass         |
| TicketCollectionTest_2 | testAddInvalidTicket          | Invalid ticket         | Throw exception    | Throw exception   | Pass         |
| TicketCollectionTest_3 | testGetTicketByIdValid        | Valid ID               | Equal info         | Equal info        | Pass         |
| TicketCollectionTest_4 | testGetTicketByIdInvalid      | Invalid ID             | Throw exception    | Throw exception   | Pass         |
| TicketTest_1         | testTicketCreation              | Valid ticket           | Equal info         | Equal info        | Pass         |
| TicketTest_2         | testPriceCalculationWithDiscount | Young/old passenger   | 56/0               | 56/0              | Pass         |
| TicketTest_3         | testPriceCalculationWithServiceTax | 300                  | 336                | 336               | Pass         |
| TicketTest_4         | testNegativePriceException      | -100                   | Throw exception    | Throw exception   | Pass         |
| TicketSystemTest_1   | validTicketSystemCreation       | Valid system           | DoesNotThrow       | DoesNotThrow      | Pass         |
| TicketSystemTest_2   | testValidChooseDirectFlightTicket | Valid direct flight   | DoesNotThrow       | DoesNotThrow      | Pass         |
| TicketSystemTest_3   | testValidChooseIndirectFlightTicket | Valid indirect flight | DoesNotThrow     | DoesNotThrow      | Pass         |
| TicketSystemTest_4   | testInvalidChooseFlight         | Invalid choice         | Throw exception    | Throw exception   | Pass         |
| TicketSystemTest_5   | testBookingBookedTickets        | Booked ticket          | Throw exception    | Throw exception   | Pass         |
| TicketSystemTest_6   | testInvalidPasserInfo           | Invalid info           | Throw exception    | Throw exception   | Pass         |

## Authors

- **Avinash Chemmany**
- **Xuanhui Wu**
