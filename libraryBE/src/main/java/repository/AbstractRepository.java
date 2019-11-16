package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbstractRepository {

    static Connection getConnection() {
        Connection dbConnection = null;
        try {
            dbConnection = DriverManager.getConnection(
                    "jdbc:mysql://www.db4free.net:3306/library_project",
                    "mainacadlib",
                    "Test123123"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dbConnection;
    }

}
