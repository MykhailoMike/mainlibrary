package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import transferTO.Reader;

public class ReadersRepository extends AbstractRepository {

    public void addReader(String firstName, String lastName, String tel, String address, String login, String password) {
        Connection connection = getConnection();

        String query = "Insert INTO readers values(?,?,?,?,?,?)";

        try (PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, generateId());
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, tel);
            ps.setString(3, address);
            ps.setString(3, login);
            ps.setString(3, password);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int generateId() {
        Connection connection = getConnection();
        try (Statement st = connection.createStatement()) {
            st.execute("SELECT MAX(reader_id) from readers");
            ResultSet resultSet = st.getResultSet();
            resultSet.next();
            return resultSet.getInt(1) + 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Reader> getReaders() {
        Connection connection = getConnection();
        try (Statement st = connection.createStatement()) {
            st.execute("SELECT firstName, lastName FROM readers");
            return getReaders(st);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Reader> getReadersByOverdue() {

        Connection connection = getConnection();
        try (Statement st = connection.createStatement()) {
            st.execute("SELECT firstName, lastName, D.title  FROM readers A LEFT JOIN orders B ON A.reader_id= B.user_id LEFT JOIN orders_books C ON B.order_id = C.order_id LEFT JOIN books D ON D.book_id = C.book_id ");
            return getReaders(st);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private List<Reader> getReaders(Statement st) throws SQLException {

        List<Reader> readerList = new ArrayList<>();
        ResultSet rs = st.getResultSet();

        while (rs.next()) {

            Reader reader = new Reader();
            reader.setId(rs.getInt(1));
            reader.setFirstName(rs.getString(2));
            reader.setLastName(rs.getString(3));
            reader.setTel(rs.getString(4));
            reader.setAddress(rs.getString(5));
            reader.setLogin(rs.getString(6));
            reader.setPassword(rs.getString(7));

            readerList.add(reader);
        }
        return readerList;
    }

}
