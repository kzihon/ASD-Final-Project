package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private String accountNumber;
    private double balance;
    private double interestRate;
    private List<AccountOperation> accountOperations;
    private Customer customer;
    private IModel model;

    public Account(String accountNumber, Customer customer) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance= 0;
        this.accountOperations= new ArrayList<>();
    }

    public void makeWithdrawal(double amount, AccountOperation accountOperation) throws IllegalArgumentException{
        this.reduceBalanceForWithdrawal(amount);
        this.accountOperations.add(accountOperation);
        String message= "Dear "+ customer.getName()+ ", you've withdraw $"+ amount+ " from your bank account.";
        this.customer.setEmail(message);



    }
    protected void reduceBalanceForWithdrawal(double amount){
        if(this.balance>=amount){
            this.balance-=amount;
        }
        else throw new IllegalArgumentException("Low Balance.");
    }

    public void makeDeposit(double amount, AccountOperation accountOperation){

        this.increaseBalanceForDeposit(amount);
        this.accountOperations.add(accountOperation);
        String message= "Dear "+ customer.getName()+ ", you've deposited $"+ amount+ " to your bank account.";
        this.customer.sendEmail(message);



    }
    protected void increaseBalanceForDeposit(double amount){
        this.balance+=amount;
    }
    public abstract void addInterest();
   final public double getBalance(){

        return balance;
    }
    public final List<AccountOperation> getOperations(){

        return this.accountOperations;
    }
    public final void addOperation(AccountOperation operation){
        accountOperations.add(operation);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public final void setBalance(double balance) {
        this.balance = balance;
    }

    public final double getInterestRate() {
        return interestRate;
    }

    public final void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public List<AccountOperation> getAccountOperations() {
        return accountOperations;
    }

    public void setAccountOperations(List<AccountOperation> accountOperations) {
        this.accountOperations = accountOperations;
    }

    public Customer getCustomer() {
        return customer;
    }
}
