package model;

import java.time.LocalDate;

public class Person extends Customer {
    private LocalDate birthdate;

    public Person(String name, String email,  LocalDate birthdate, String street, String city, String state, String zip) {
        super(name, email, street, city, state, zip);
        this.birthdate = birthdate;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public void sendEmail(String message) {

    }
}
