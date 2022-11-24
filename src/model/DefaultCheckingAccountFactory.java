package model;

import interfaces.IAccount;
import interfaces.ICustomer;

public class DefaultCheckingAccountFactory implements AccountFactory {
	protected DefaultCheckingAccountFactory() { }

	@Override
	public IAccount createAccount(ICustomer customer, String accountNumber) {
		return new DefaultCheckingAccount(accountNumber, customer);
	}

}
