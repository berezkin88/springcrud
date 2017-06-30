package CRUDapp.service;

import CRUDapp.model.Book;

import java.util.List;

/**
 * Created by Alexander on 01/07/2017.
 */
public interface BookService {

    void addBook (Book book);

    void updateBook(Book book);

    void deleteBook(long id);

    Book getBookById(long id);

    List<Book> listBooks();
}
