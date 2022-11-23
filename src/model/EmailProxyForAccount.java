package model;

import rules.IFinancialRule;

import java.util.List;

public class EmailProxyForAccount extends Account {
    private Account account;
    private String depositEmailMessage;
    private String withdrawalEmailMessage;


    public EmailProxyForAccount(String accountNumber, Customer customer, Account account) {
        super(accountNumber, customer);
        this.account = account;
    }

    @Override
    public void makeWithdrawal(double amount, AccountOperation accountOperation, List<IFinancialRule> financialRules) throws IllegalArgumentException{
        System.out.println("Withdrawal operation with  email sending!");
        super.makeWithdrawal(amount, accountOperation, financialRules);
        super.getCustomer().sendEmail( String.format( "Dear %s, you've withdrawed $%f.2 from your bank account.",
                super.getCustomer().getName(), amount));
    }

    @Override
    public void makeDeposit(double amount, AccountOperation accountOperation,List<IFinancialRule> financialRules){
        System.out.println("deposit operation with email sending");
        super.makeDeposit(amount, accountOperation, financialRules);
        super.getCustomer().sendEmail(String.format("Dear %s, you've deposited $%f.2 on your bank account.",
                super.getCustomer().getName(), account));
    }


        @Override
    public void addInterest() {
        this.account.addInterest();
    }

    public String getDepositEmailMessage() {
        return depositEmailMessage;
    }

    public void setDepositEmailMessage(String depositEmailMessage) {
        this.depositEmailMessage = depositEmailMessage;
    }

    public String getWithdrawalEmailMessage() {
        return withdrawalEmailMessage;
    }

    public void setWithdrawalEmailMessage(String withdrawalEmailMessage) {
        this.withdrawalEmailMessage = withdrawalEmailMessage;
    }
}
