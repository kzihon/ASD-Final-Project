package app;

import model.Account;
import model.AccountOperation;
import test.CheckingAccount;
import test.DepositOperation;
import test.Person;
import view.IView;

import java.time.LocalDate;

public class App implements IView {
    public static void main(String[] args) {
        Person person= new Person("Jack", "Jack@gmail.com", LocalDate.now(), "1000 N","Fairfield",
                "IA", "52557");
        Account checkingAccount= new CheckingAccount("123445", person);
        AccountOperation deposit= new DepositOperation(200,LocalDate.now());
        checkingAccount.makeDeposit(200, deposit);

    }

    public static void init(){
    }

    @Override
    public void update() {

    }
}
