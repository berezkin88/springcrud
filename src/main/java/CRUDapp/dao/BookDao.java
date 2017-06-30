package CRUDapp.dao;

import CRUDapp.model.Book;

import java.util.List;

/**
 * Created by Alexander on 30/06/2017.
 */
public interface BookDao {

    void addBook (Book book);

    void updateBook(Book book);

    void deleteBook(long id);

    Book getBookById(long id);

    List<Book> listBooks();
}
