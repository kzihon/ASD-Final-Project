package model;

import java.util.List;

public abstract class Account {
    private String accountNumber;
    private double balance;
    private double interestRate;
    private List<AccountOperation> accountOperations;
    private Customer customer;


}
