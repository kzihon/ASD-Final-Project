package rules;

import model.Account;

import java.util.List;

public interface IFinancialRule {
    boolean apply(Account account, double amount);

}
