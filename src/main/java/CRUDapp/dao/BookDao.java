package CRUDapp.dao;

import CRUDapp.model.Book;

import java.util.List;

/**
 * Created by Alexander on 30/06/2017.
 */
public interface BookDao {

    void addBook (Book book);

    void updateBook(Book book);

    void deleteBook(Long id);

    Book getBookById(Long id);

    List<Book> listBooks();
}
