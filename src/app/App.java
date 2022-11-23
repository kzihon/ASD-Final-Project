package app;

import config.ConfigJdbc;
import model.Account;
import model.AccountOperation;
import model.EmailProxyForAccount;
import rules.IFinancialRule;
import test.CheckingAccount;
import test.Person;
import test.WithDrawOperation;
import view.IView;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class App implements IView {
    public static Connection connection;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Person person= new Person("Kidist", "kidist@gmail.com", LocalDate.now(), "1090 N",
                "Kansas City",
                "Mo", "42557");
        Account checkingAccount= new CheckingAccount("123445", person);

        //AccountOperation deposit= new DepositOperation(200,LocalDate.now());

        EmailProxyForAccount accountProxy = new EmailProxyForAccount("123445", person, checkingAccount);

        AccountOperation withdraw= new WithDrawOperation(0,LocalDate.now());


        IFinancialRule  lowBalanceRule =(account, amount) ->  account.getBalance()-amount<0;

        List<IFinancialRule> withdrawRules= new ArrayList<>();
        withdrawRules.add(lowBalanceRule);

        //checkingAccount.makeWithdrawal(600, withdraw, withdrawRules);

//        IFinancialRule  depositAbove400 =(account, amount)->{
//            if(amount< 400)
//                return false;
//            return true;
//        };
    //    checkingAccount.makeDeposit(200, deposit, rules);

        accountProxy.setBalance(1000);
        accountProxy.makeWithdrawal(200, withdraw, withdrawRules);

        checkingAccount.setBalance(1000);
        checkingAccount.makeWithdrawal(200, withdraw, withdrawRules);

        Connection conn = initJdbc();
        Statement statement = conn.createStatement();
            String sql = "insert into Customer(id, name, email, street, city, state, zip, birthdate, customer_type) values(null, '"
                    + person.getName() + "', '"
                    + person.getEmail() + "', '"
                    + person.getAddress().getStreet() + "', '"
                    + person.getAddress().getCity() + "', '"
                    + person.getAddress().getState() + "', '"
                    + person.getAddress().getZip() + "', '"
                    + person.getBirthdate().format(DateTimeFormatter.ISO_DATE) + "', '"
                    + "PERSON')";
            System.out.println(statement.execute(sql));






//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankApplicationDB",
//                    "root", "Ethiopia12");
//            Statement statement = conn.createStatement();
//            String sql = "insert into Customer(id, name, email, street, city, state, zip, birthdate, customer_type) values(null, '"
//                    + person.getName() + "', '"
//                    + person.getEmail() + "', '"
//                    + person.getAddress().getStreet() + "', '"
//                    + person.getAddress().getCity() + "', '"
//                    + person.getAddress().getState() + "', '"
//                    + person.getAddress().getZip() + "', '"
//                    + person.getBirthdate().format(DateTimeFormatter.ISO_DATE) + "', '"
//                    + "PERSON')";
////
//            System.out.println(statement.execute(sql));
//        } catch (Exception e) {
//            System.out.println("EXCEPTION");
//            System.out.println(e.getMessage());
//        }

    }

    public static Connection initJdbc() throws SQLException {
        ConfigJdbc configJdbc= new ConfigJdbc("root","Ethiopia12","localhost", 3306,
                "BankApplicationDB");
        return configJdbc.setConnection();
    }

    @Override
    public void update() {

    }
}
