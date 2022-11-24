package interfaces;

import java.util.List;

import model.IModel;

public interface IAccount extends IModel {
	double getBalance();
	void makeWithdrawal(double amount, IEntry accountOperation);
	void makeDeposit(double amount, IEntry accountOperation);
	ICustomer getCustomer();
	void addInterest();
	String getAccountNumber();
	double getInterestRate();
	List<IEntry> getOperations();
}
