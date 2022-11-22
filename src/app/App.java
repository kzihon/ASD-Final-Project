package app;

import config.ConfigJdbc;
import model.Account;
import model.AccountOperation;
import test.CheckingAccount;
import test.DepositOperation;
import test.Person;
import view.IView;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App implements IView {
    public static Connection connection;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Person person= new Person("Jack", "Jack@gmail.com", LocalDate.now(), "1000 N","Fairfield",
                "IA", "52557");
        Account checkingAccount= new CheckingAccount("123445", person);
        AccountOperation deposit= new DepositOperation(200,LocalDate.now());
        checkingAccount.makeDeposit(200, deposit);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankApplicationDB",
                    "root", "Ethiopia12");
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
//
            System.out.println("HERE");
            System.out.println(statement.execute(sql));
        } catch (Exception e) {
            System.out.println("EXCEPTION");
            System.out.println(e.getMessage());
        }

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
