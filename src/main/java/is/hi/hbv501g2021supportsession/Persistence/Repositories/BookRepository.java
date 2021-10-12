package is.hi.hbv501g2021supportsession.Persistence.Repositories;

import is.hi.hbv501g2021supportsession.Persistence.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book save(Book book);
    void delete(Book book);

    List<Book> findAll();
    List<Book> findByTitle(String title);
    Book findByID(long id);
}
