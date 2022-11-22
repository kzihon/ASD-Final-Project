package test;

import model.AccountOperation;

import java.time.LocalDate;

public class DepositOperation extends AccountOperation {

    public DepositOperation(double amount, LocalDate date) {
        super(amount, date);
    }

    @Override
    public void execute() {
        System.out.println("Deposit executed");
    }

}
