package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import libraryFXclient.to.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BooksRepository extends AbstractRepository{

    public List<Book> getBooksToRepository (){
        Connection connection = getConnection();
        try (Statement st = connection.createStatement()) {
            st.execute("SELECT book_id, title, year, " +
                    "author, st_book_id, order_id FROM books");
            return createBoooksList(st);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Book> createBoooksList(Statement st) throws SQLException {
        List<Book> booksList = new ArrayList<>();
        ResultSet rs = st.getResultSet();

        while (rs.next()) {

            Book book = new Book();
            book.setBookID(rs.getInt(1));
            book.setBookTitile(rs.getString(2));
            book.setBookYear(rs.getString(3));
            book.setBookAuthor(rs.getString(4));
            book.setStatusBookID(rs.getInt(5));
            book.setOrderID(rs.getInt(6));

            booksList.add(book);
        }
        return booksList;
    }

}
