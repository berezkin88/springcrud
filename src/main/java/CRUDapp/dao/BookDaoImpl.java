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
    public void deleteBook(long id) {
        Book book = (Book) sessionFactory.getCurrentSession().load(Book.class, id);

        if (book != null){
            sessionFactory.getCurrentSession().delete(book);
            System.out.println("Book is successfully deleted");
        } else {
            System.out.println("Book not found");
        }
    }

    @Override
    public Book getBookById(long id) {
        Book book = (Book) sessionFactory.getCurrentSession().createQuery("select b from Book b where b.id like :id").
                setParameter("id", id).uniqueResult();
        System.out.println("The book is successfully found. Book details: " + book.toString());
        return book;
    }

    @Override
    @SuppressWarnings("uncheked")
    public List listBooks() {
        return sessionFactory.getCurrentSession().createQuery("select b from Book b").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
