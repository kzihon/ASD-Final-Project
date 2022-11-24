package model;

import java.time.LocalDate;

public class DefaultDepositEntry extends Entry {

    public DefaultDepositEntry(double amount, LocalDate date) {
        super(amount, date);
    }

    @Override
    public void execute() {
        System.out.println("Deposit executed");
    }

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
