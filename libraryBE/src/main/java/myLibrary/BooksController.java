package myLibrary;

import libraryFXclient.to.Book;
import libraryFXclient.to.BookTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.BooksRepository;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class BooksController {

    @Autowired
    BooksRepository booksRepository;

    @ResponseBody
    @GetMapping ("/books")
    public List<Book> getBooksToController(){
        return booksRepository.getBooksToRepository();
    }

    //findBooks;
    //myBooks;

}
