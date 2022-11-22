package model;

import java.time.LocalDate;
import java.util.Objects;

public class Bank {


    private String name;
    private String legalName;
    private String logo;
    private String phoneNumber;
    private LocalDate establishedYear;
    private String Type;

    private Address address;

    private Bank() {
        this.name="Bank";
        this.legalName="My Bank";
    }

    private static Bank instance  = new Bank();

    public static Bank getInstance(){
        if(Objects.isNull(instance)){
            return new Bank();
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getEstablishedYear() {
        return establishedYear;
    }

    public void setEstablishedYear(LocalDate establishedYear) {
        this.establishedYear = establishedYear;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static void setInstance(Bank instance) {
        Bank.instance = instance;
    }
}
