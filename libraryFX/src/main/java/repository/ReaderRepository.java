package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReaderRepository extends DBConfigs {

    Connection dbConnection;

    public Connection getDbConnection () throws ClassNotFoundException, SQLException {

        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort +
                dbName + "?useJDBCCompliantTimezoneShift=true" +
                "&useLegacyDatetimeCode=false&serverTimezone=UTC";

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;

    }

    public void signUpReader (String firstname, String lastname, String tel, String address,
                            String login, String password){
        String insert = "INSERT INTO " + DBConstants.USER_TABLE + "("
                + DBConstants.USERS_FIRSTNAME + ","
                + DBConstants.USERS_LASTNAME + ","
                + DBConstants.USERS_PHONE + ","
                + DBConstants.USERS_ADDRESS + ","
                + DBConstants.USERS_LOGIN + ","
                + DBConstants.USERS_PASSWORD + ","
                + "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);

            prSt.setString(1, firstname);
            prSt.setString(2, lastname);
            prSt.setString(4, tel);
            prSt.setString(5, address);
            prSt.setString(6, login);
            prSt.setString(7, password);

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
