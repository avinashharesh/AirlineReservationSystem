package fit5171.monash.edu;

import java.util.Arrays;
import java.util.List;

public abstract class Person {
    private String firstName;
    private String secondName;
    private int age;
    private String gender;

    private static final List<String> VALID_GENDERS = Arrays.asList(
            "Female", "Male", "Non-binary|gender diverse", "Prefer not to say", "Other");

    public Person() {}

    public Person(String firstName, String secondName, int age, String gender) {
        validateRequiredField(firstName, "First name");
        validateRequiredField(secondName, "Second name");
        validateRequiredField(gender, "Gender");
        validateAge(age);
        validateName(firstName, "First name");
        validateName(secondName, "Second name");
        validateGender(gender);

        this.age = age;
        this.firstName = firstName;
        this.secondName = secondName;
        this.gender = gender;
    }

    private void validateRequiredField(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " is required and cannot be empty.");
        }
    }

    private void validateAge(int value) {
        if (value == 0) {
            throw new IllegalArgumentException("Age is required and cannot be 0.");
        }
    }

    private void validateName(String name, String fieldName) {
        if (!name.matches("^[A-Za-z]+[A-Za-z]*$")) {
            throw new IllegalArgumentException(fieldName + " must start with a letter and contain only letters.");
        }
    }

    private void validateGender(String gender) {
        if (!VALID_GENDERS.contains(gender)) {
            throw new IllegalArgumentException("Invalid gender. Must be one of " + VALID_GENDERS);
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        validateAge(age);
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        validateGender(gender);
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setFirstName(String firstName) {
        validateRequiredField(firstName,"First name");
        validateName(firstName, "First name");
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        validateRequiredField(firstName,"Second name");
        validateName(secondName, "Second name");
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
