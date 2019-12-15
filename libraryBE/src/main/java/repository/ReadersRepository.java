package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import libraryFXclient.to.Reader;
import org.springframework.stereotype.Repository;

@Repository
public class ReadersRepository extends AbstractRepository {

    public List<Reader> getReadersToRepository() {

        Connection connection = getConnection();
        try (Statement st = connection.createStatement()) {
            st.execute("SELECT reader_id, firstName, lastName, " +
                    "tel, address, login, password FROM readers");
            return createReadersList(st);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private List<Reader> createReadersList(Statement st) throws SQLException {

        List<Reader> readersList = new ArrayList<>();
        ResultSet rs = st.getResultSet();

        while (rs.next()) {

            Reader reader = new Reader();
            reader.setID(rs.getInt(1));
            reader.setFirstName(rs.getString(2));
            reader.setLastName(rs.getString(3));
            reader.setTel(rs.getString(4));
            reader.setAddress(rs.getString(5));
            reader.setLogin(rs.getString(6));
            reader.setPassword(rs.getString(7));

            readersList.add(reader);
        }
        return readersList;
    }

    public void createNewReaderStatement(String firstName, String lastName, String tel,
                                         String address, String login, String password){
        Connection connection = getConnection();

        String query = "Insert INTO readers values(?,?,?,?,?,?,?)";

        try (PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, generateId());
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, tel);
            ps.setString(5, address);
            ps.setString(6, login);
            ps.setString(7, password);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int generateId() {
        Connection connection = getConnection();
        try (Statement st = connection.createStatement()) {
            st.execute("SELECT MAX(id) from readers");
            ResultSet resultSet = st.getResultSet();
            resultSet.next();
            return resultSet.getInt(1) + 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
