package app;

import model.AccountFactory;
import model.CustomerFactory;
import model.DefaultDepositEntry;
import model.DefaultSimpleAccountFactory;
import model.Entry;
import model.Person;
import view.AccountListView;
import view.CreateCompanyAccountModal;
import view.CreatePersonalAccountModal;
import view.CreationalAction;
import view.FinancialAction;
import view.FinancialOperationModalView;
import view.InterestAction;
import view.MainFrame;
import view.RadioButtonTypeAccount;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.UIManager;

import controller.DefaultPersonalCheckingAccountController;
import interfaces.IAccount;

public class App {
    public static void main(String[] args) {
    	runSwingMode();
    }

    public static void init(){
    }
    
    static void runSwingMode() {
    	try {
		    // Add the following code if you want the Look and Feel
		    // to be set to the Look and Feel of the native system.
		    
		    try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (Exception e) { }
		    
			//Create a new instance of our application's frame, and make it visible.
		    MainFrame index = new MainFrame("MyBank - Framework");
		    AccountListView accountData = new AccountListView();
		    index.setListView(accountData);
		    
		    String addPersonalAccountTitle = "Add personal account";
		    ArrayList<RadioButtonTypeAccount> listPersonalAcountTypeOptions = new ArrayList<>();
		    listPersonalAcountTypeOptions.add(new RadioButtonTypeAccount("Checkings"));
		    //listPersonalAcountTypeOptions.add(new RadioButtonTypeAccount("Savings"));
		    CreatePersonalAccountModal modalCreatePersonalAccount = 
		    		new CreatePersonalAccountModal(index, addPersonalAccountTitle, listPersonalAcountTypeOptions);
		    modalCreatePersonalAccount.setController(new DefaultPersonalCheckingAccountController());
		    CreationalAction actionCreatePersonalAccount = 
		    		new CreationalAction(addPersonalAccountTitle, modalCreatePersonalAccount);
		    index.addCreationalAction(actionCreatePersonalAccount);
		    
		    /*String addCompanyAccountTitle = "Add company account";
		    ArrayList<RadioButtonTypeAccount> listCompanyAccountTypeOptions = new ArrayList<>();
		    listCompanyAccountTypeOptions.add(new RadioButtonTypeAccount("Checkings"));
		    listCompanyAccountTypeOptions.add(new RadioButtonTypeAccount("Savings"));
		    CreateCompanyAccountModal modalCreateCompanyAccount = 
		    		new CreateCompanyAccountModal(index, "Add company account", listCompanyAccountTypeOptions);
		    modalCreateCompanyAccount.setController(null); // To be added
		    CreationalAction actionCreateCompanyAccount = 
		    		new CreationalAction(addCompanyAccountTitle, modalCreateCompanyAccount);
		    index.addCreationalAction(actionCreateCompanyAccount);*/
		    
		    String depositTitle = "Deposit";
		    FinancialOperationModalView depositModal = 
		    		new FinancialOperationModalView(index, depositTitle, "Acc. No.");
		    depositModal.setController(null); // To be added
		    FinancialAction depositAction = 
		    		new FinancialAction(index, depositTitle, depositModal);
		    index.addFinancialAction(depositAction);
		    
		    String withdrawTitle = "Withdraw";
		    FinancialOperationModalView withdrawModal = 
		    		new FinancialOperationModalView(index, withdrawTitle, "Acc. No.");
		    withdrawModal.setController(null); // To be added
		    FinancialAction withdrawAction = 
		    		new FinancialAction(index, withdrawTitle, withdrawModal);
		    index.addFinancialAction(withdrawAction);
		    
		    String interestActionWarning = "You are about to add interest to all accounts.\n";
		    interestActionWarning += "Press OK to validate or just cancel if not sure.";
		    InterestAction interestAction = 
		    		new InterestAction(index, "Add interest", interestActionWarning);
		    interestAction.setController(null); // To be added
		    index.addInterestAction(interestAction);
		    
		    index.setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
    }
    
    static void runConsoleMode() {
    	CustomerFactory customerFactory = new CustomerFactory();
    	Person person = (Person)customerFactory.createPerson("Jack", LocalDate.now(), "Jack@gmail.com", "1000 N","Fairfield",
                "IA", "52557");
    	
    	AccountFactory factory = DefaultSimpleAccountFactory.getCheckingAccountFactory();
		IAccount checkingAccount = factory.createAccount(person, "123445");

        Entry deposit = new DefaultDepositEntry(200,LocalDate.now());
        checkingAccount.makeDeposit(200, deposit);
    }
}
