package model;

import interfaces.IAccount;
import interfaces.ICustomer;

public interface AccountFactory {
    public IAccount createAccount(ICustomer customer, String accountNumber);
}
