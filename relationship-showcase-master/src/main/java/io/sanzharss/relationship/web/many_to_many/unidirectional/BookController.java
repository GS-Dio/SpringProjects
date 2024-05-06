package io.sanzharss.relationship.web.many_to_many.unidirectional;

import io.sanzharss.relationship.domain.many_to_many.unidirectional.Book;
import io.sanzharss.relationship.service.many_to_many.unidirectional.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    public final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PostMapping("/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book) {
        return bookService.update(id, book);
    }

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id){
        return bookService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        bookService.delete(id);
    }
}
