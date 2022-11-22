package test;

import model.Account;
import model.Customer;

public class CheckingAccount extends Account {

    public CheckingAccount(String accountNumber, Customer customer) {
        super(accountNumber, customer);
    }

    @Override
    public void addInterest() {

    }
}
