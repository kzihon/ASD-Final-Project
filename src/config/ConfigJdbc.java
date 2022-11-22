package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigJdbc {
    Connection conn = null;
    private String userName;
    private String password;
    private String jdbcUrl;
    private int port;

    private String dbName;

    public ConfigJdbc(String userName, String password, String jdbcUrl, int port, String dbName ) throws SQLException {
        this.userName= userName;
        this.password= password;
        this.jdbcUrl=jdbcUrl;
        this.port = port;
        this.dbName= dbName;
    }

    public Connection setConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + getJdbcUrl() + ":"
                    + getPort() + "/" + getDbName() + "?" +
                    "user=" + getUserName() + "&password=" + getPassword());
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return conn;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
}
