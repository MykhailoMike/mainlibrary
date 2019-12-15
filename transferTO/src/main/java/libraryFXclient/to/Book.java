package libraryFXclient.to;

public class Book {

    private int bookID;
    private String bookTitle;
    private String bookYear;
    private String bookAuthor;
    private int statusBookID;
    private int orderID;


    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookTitile() {
        return bookTitle;
    }

    public void setBookTitile(String bookTitile) {
        this.bookTitle = bookTitile;
    }

    public String getBookYear() {
        return bookYear;
    }

    public void setBookYear(String bookYear) {
        this.bookYear = bookYear;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getStatusBookID() {
        return statusBookID;
    }

    public void setStatusBookID(int statusBookID) {
        this.statusBookID = statusBookID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", bookTitile='" + bookTitle + '\'' +
                ", bookYear='" + bookYear + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", statusBookID=" + statusBookID +
                ", orderID=" + orderID +
                '}';
    }
}
