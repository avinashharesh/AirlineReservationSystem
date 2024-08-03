package fit5171.monash.edu;

public class Passenger extends Person {
    private String email;
    private String phoneNumber;
    private String passport;
    private String cardNumber;
    private int securityCode;

    public Passenger() {}

    public Passenger(String firstName, String secondName, int age, String gender, String email, String phoneNumber, String passport, String cardNumber, int securityCode) {
        super(firstName, secondName, age, gender);
        validRequiredField(passport,"Passport");
        validRequiredField(cardNumber,"Card Number");
        validateEmail(email);
        validatePhoneNumber(phoneNumber);
        validatePassport(passport);

        this.email = email;
        this.phoneNumber = phoneNumber;
        this.passport = passport;
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
    }

    private void validateEmail(String email) {
        if (email == null || !email.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")) {
            throw new IllegalArgumentException("Invalid email format.");
        }
    }

    private void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches("^(04|05)\\d{8}$")) {
            throw new IllegalArgumentException("Invalid Australian mobile phone number.");
        }
    }

    private void validatePassport(String passport) {
        if (passport == null || passport.length() > 9) {
            throw new IllegalArgumentException("Passport number must not be more than 9 characters long.");
        }
    }

    private void validRequiredField(String value,String FieldName)
    {
        if(value==null || value.isEmpty())
            throw new IllegalArgumentException(FieldName+" cannot be empty");
    }

    // Standard getter and setter methods
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        validRequiredField(email,"Email");
        validateEmail(email);
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        validRequiredField(phoneNumber,"Phone Number");
        validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        validRequiredField(passport,"Passport");
        validatePassport(passport);
        this.passport = passport;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        validRequiredField(passport,"Passport");
        this.cardNumber = cardNumber;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "firstName='" + getFirstName() + '\'' +
                ", secondName='" + getSecondName() + '\'' +
                ", age=" + getAge() +
                ", gender='" + getGender() + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", passport='" + passport + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", securityCode=" + securityCode +
                '}';
    }
}
