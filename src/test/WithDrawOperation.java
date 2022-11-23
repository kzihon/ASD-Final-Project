package test;

import model.AccountOperation;

import java.time.LocalDate;

public class WithDrawOperation extends AccountOperation {

    public WithDrawOperation(double amount, LocalDate date) {
        super(amount, date);
    }

    @Override
    public void execute() {
        System.out.println("withdraw executed");
    }

}
