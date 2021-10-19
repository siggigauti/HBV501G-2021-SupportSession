package is.hi.hbv501g2021supportsession.Controllers;

import is.hi.hbv501g2021supportsession.Persistence.Entities.Book;
import is.hi.hbv501g2021supportsession.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {
    private BookService bookService;

    @Autowired
    public HomeController(BookService bookService){
        this.bookService = bookService;
    }

    @RequestMapping("/")
    public String homePage(Model model){
        //Call a method in a Service Class
        List<Book> allBooks = bookService.findAll();
        //Add some data to the Model
        model.addAttribute("books", allBooks);
        return "home";
    }

    @RequestMapping(value = "/addbook", method = RequestMethod.GET)
    public String addBookGET(Book book){

        return "newBook";
    }

    @RequestMapping(value = "/addbook", method = RequestMethod.POST)
    public String addBookPOST(Book book, BindingResult result, Model model){
        if(result.hasErrors()){
            return "newBook";
        }
        bookService.save(book);
        return "redirect:/";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") long id, Model model){
        Book bookToDelete = bookService.findByID(id);
        bookService.delete(bookToDelete);
        return "redirect:/";
    }
}
