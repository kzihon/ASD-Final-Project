package model;

import java.time.LocalDate;

import interfaces.ICompany;
import interfaces.IPerson;

/**
 *
 * Factory to create a customer
 * @author Group 3
 */
public class CustomerFactory {

    /**
     * Concrete customer factory
     *
     * @param name customer's name
     * @param email customer's
     * @param street
     * @param city
     * @return
     */
    public IPerson createPerson(String name, LocalDate birthdate, String street, String city, String state, String zip, String email) {
    	return new Person(name, email, birthdate, street, city, state, zip);
    }

    public ICompany createCompany(String name, int numberOfEmployees, String street, String city, String state, String zip, String email) {
    	return new Company(name, email, numberOfEmployees, street, city, state, zip);
    }

}
