package model;

public interface AccountFactory {
    public Account createAccount(String accountNumber, Customer customer);
}
