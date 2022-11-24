package rules;

import interfaces.IAccount;
import interfaces.IRule;

public class DefaultDepositRule implements IRule {

	@Override
	public boolean isApplicable(IAccount account, double amount) {
		return amount > 400;
	}

	@Override
	public void apply(IAccount account, double amount) {
		account.getCustomer().sendEmail("You're about to make a deposit of " + amount);
	}

}
