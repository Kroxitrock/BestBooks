package bg.bestbooks.components.book.controller;

import bg.bestbooks.components.book.model.Book;
import bg.bestbooks.components.book.repository.BooksRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksController {

  private final BooksRepository booksRepository;

  @Autowired
  public BooksController(BooksRepository booksRepository) {
    this.booksRepository = booksRepository;
  }

  @PostMapping(consumes = "application/json")
  public Book saveBook(@RequestBody Book book) {
    return booksRepository.save(book);
  }

  @GetMapping(produces = "application/json")
  public List<Book> findAll() {
    return booksRepository.findAll();
  }

  @GetMapping(path = "/{id}", produces = "application/json")
  public Book findById(@PathVariable Integer id) {
    Optional<Book> book = booksRepository.findById(id);

    return book.orElse(null);
  }

  @PutMapping(consumes = "application/json")
  public void updateBook(@RequestBody Book book) {
    booksRepository.save(book);
  }

  @DeleteMapping(path = "/{id}")
  public void deleteById(@PathVariable Integer id) {
    booksRepository.deleteById(id);
  }
}
