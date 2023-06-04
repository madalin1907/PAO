package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;
    private static final String url = "jdbc:mysql://localhost:3306/pao";
    private static final String username = "root";
    private static final String password = "root";

    private DBConnection() {
    }

    public static Connection getInstance() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(url, username, password);
        }

        return connection;
    }
}