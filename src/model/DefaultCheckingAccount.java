package model;

import interfaces.ICustomer;

public class DefaultCheckingAccount extends Account {

    protected DefaultCheckingAccount(String accountNumber, ICustomer customer) {
        super(accountNumber, customer);
    }

    @Override
    public void addInterest() {

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
