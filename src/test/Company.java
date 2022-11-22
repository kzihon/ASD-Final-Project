package test;

import model.Customer;

public class Company extends Customer {
    private int numberOfEmployees;

    public Company(String name, String email, int numberOfEmployees,String street, String city, String state, String zip) {
        super(name, email, street,city,state,zip);
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public void sendEmail(String message) {

    }
}
