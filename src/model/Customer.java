package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Customer {
    private String name;
    private String email;
    private List<Account> accounts;
    private Address address;

    protected Customer(String name, String email, String street, String city, String state, String zip) {
        Address address= new Address(street, city, state, zip);
        this.name = name;
        this.email = email;
        this.address = address;
        this.accounts= new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;

    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account accounts) {
        this.accounts.add(accounts);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public  abstract void sendEmail(String message);
}
