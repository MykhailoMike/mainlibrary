package repository;

import libraryFXclient.to.Librarian;
import libraryFXclient.to.Reader;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LibrariansRepository extends AbstractRepository {

    public List<Librarian> getLibrariansToRepository() {
        Connection connection = getConnection();
        try (Statement st = connection.createStatement()) {
            st.execute("SELECT librarian_id, firstName, lastName, " +
                    "login, password FROM librarians");
            return createLibrariansList(st);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private List<Librarian> createLibrariansList(Statement st) throws SQLException {

        List<Librarian> librariansList = new ArrayList<>();
        ResultSet rs = st.getResultSet();

        while (rs.next()) {

            Librarian librarian = new Librarian();
            librarian.setID(rs.getInt(1));
            librarian.setFirstName(rs.getString(2));
            librarian.setLastName(rs.getString(3));
            librarian.setLogin(rs.getString(4));
            librarian.setPassword(rs.getString(5));

            librariansList.add(librarian);
        }
        return librariansList;
    }
}
