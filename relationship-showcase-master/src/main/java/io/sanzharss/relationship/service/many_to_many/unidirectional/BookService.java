package io.sanzharss.relationship.service.many_to_many.unidirectional;

import io.sanzharss.relationship.domain.many_to_many.unidirectional.Book;
import io.sanzharss.relationship.repository.many_to_many.unidirectionalRepository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookService {

    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book){
        return bookRepository.save(book);
    }

    public Book update(Long id,Book updateBook){
        Optional<Book> optionalBook = bookRepository.findById(id);

        if(optionalBook.isPresent()){
            Book myBook = optionalBook.get();

            myBook.setTitle(updateBook.getTitle());

            return bookRepository.save(myBook);
        }else
            log.warn("Book " + id + " not found!");

        return updateBook;
    }

    public Book findById(Long id){
        Optional<Book> optionalBook = bookRepository.findById(id);

        if(optionalBook.isPresent()){
            return optionalBook.get();
        }else
            log.warn("Book " + id + " not found!");

        return null;
    }

    public List<Book> findAll(){
        List<Book> books = new LinkedList<>();

        bookRepository.findAll().forEach(books::add);
        return books;
    }

    public void delete(Long id){
        bookRepository.deleteById(id);
    }


}
