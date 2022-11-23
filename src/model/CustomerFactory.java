package model;

import java.time.LocalDate;

/**
 *
 * Factory to create a customer
 * @author Group 3
 */
public  class CustomerFactory {

    /**
     * Concrete customer factory
     *
     * @param name customer's name
     * @param email customer's
     * @param street
     * @param city
     * @return
     */
    public static Person createPerson(String name, String street, String city, String state, String zip, String email, LocalDate birthdate){
        Person person= new Person(name,email,birthdate,street,city,state,zip);
        return person;
    }

    public static Company createCompany(String name, String street, String city, String state, String zip, String email, int numberOfEmployees){
        Company company= new Company(name,email,numberOfEmployees,street,city,state,zip);
        return company;
    }


}
