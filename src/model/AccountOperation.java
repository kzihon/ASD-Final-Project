package model;

import java.time.LocalDate;
import java.util.Date;

public abstract class AccountOperation {
    private double amount;
    private LocalDate date;

    public AccountOperation(double amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }
    public abstract void execute();
}
