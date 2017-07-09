package CRUDapp.controller;

import CRUDapp.model.Book;
import CRUDapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Alexander on 01/07/2017.
 */
@Controller
public class BookController {

    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String listBooks(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("listBooks", bookService.listBooks());
        return "books";
    }

    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book) {
        if (book.getId() == 0) {
            bookService.addBook(book);
        } else {
            bookService.updateBook(book);
        }
        return "redirect:/books";
    }

    @RequestMapping(value = "remove/{id}")
    public String removeBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);

        return "redirect:/books";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        model.addAttribute("listBooks", bookService.listBooks());

        return "books";
    }

    @RequestMapping(value = "/bookData/{id}")
    public String bookData(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));

        return "bookData";
    }

    @Autowired
    @Qualifier(value = "bookService")
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Created by Alexander on 29/06/2017.
     */
    @Controller
    public static class IndexController {

        @RequestMapping(value = "/", method = RequestMethod.GET)
        public String index(){
            return "index";
        }
    }
}
