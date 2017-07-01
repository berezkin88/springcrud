package CRUDapp.service;

import CRUDapp.dao.BookDao;
import CRUDapp.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Alexander on 01/07/2017.
 */
@Service
public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    @Override
    @Transactional
    public void addBook(Book book) {
        this.bookDao.addBook(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    @Transactional
    public void deleteBook(long id) {
        bookDao.deleteBook(id);
    }

    @Override
    @Transactional
    public Book getBookById(long id) {
        return bookDao.getBookById(id);
    }

    @Override
    @Transactional
    public List<Book> listBooks() {
        return bookDao.listBooks();
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
