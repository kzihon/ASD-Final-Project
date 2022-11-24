package rules;

import java.util.ArrayList;
import java.util.List;

import interfaces.IAccount;
import interfaces.IRule;

public class RuleEvaluator {
	private List<IRule> rules;
	
	public RuleEvaluator() {
		this.rules = new ArrayList<>();
	}
	
	public void addRule(IRule rule) {
		this.addRule(rule);
	}
	
	public void evaluate(IAccount account, double amount) {
		for(IRule rule: this.rules) {
			if(rule.isApplicable(account, amount)) {
				rule.apply(account, amount);
			}
		}
	}
}
