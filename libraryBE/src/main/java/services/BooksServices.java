package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BooksRepository;

@Service
public class BooksServices {

    @Autowired
    BooksRepository booksRepository;

    public void orderBook() {

    }

    public void returnBook() {

    }

    public void lookForBookByTitle(String title) {

    }

    public void lookForBookByAuthor () {

    }
}
