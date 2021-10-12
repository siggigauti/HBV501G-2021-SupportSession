package is.hi.hbv501g2021supportsession.Services;

import is.hi.hbv501g2021supportsession.Persistence.Entities.Book;

import java.util.List;

public interface BookService {
    Book findByTitle(String title);
    List<Book> findAll();
    Book findByID(long ID);
    Book save(Book book);
    void delete(Book book);
}
