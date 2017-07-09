package CRUDapp.dao;

import CRUDapp.model.Book;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alexander on 30/06/2017.
 */
@Repository
public class BookDaoImpl implements BookDao {

    private SessionFactory sessionFactory;

    @Override
    public void addBook(Book book) {
        sessionFactory.getCurrentSession().save(book);
        System.out.println("Book is successfully added. Book details: " + book.toString());
    }

    @Override
    public void updateBook(Book book) {
        sessionFactory.getCurrentSession().update(book);
        System.out.println("Book is successfully updated. Book details: " + book.toString());
    }

    @Override
    public void deleteBook(Long id) {
        Book book = sessionFactory.getCurrentSession().load(Book.class, new Long(id));

        if (book != null){
            sessionFactory.getCurrentSession().delete(book);
            System.out.println("Book is successfully deleted");
        } else {
            System.out.println("Book not found");
        }
    }

    @Override
    public Book getBookById(Long id) {
        Book book = sessionFactory.getCurrentSession().load(Book.class, new Long(id));
        System.out.println("The book is successfully found. Book details: " + book.toString());
        return book;
    }

    @Override
    public List listBooks() {
        return sessionFactory.getCurrentSession().createQuery("SELECT b FROM Book b").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
