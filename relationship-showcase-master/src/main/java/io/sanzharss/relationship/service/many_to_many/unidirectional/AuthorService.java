package io.sanzharss.relationship.service.many_to_many.unidirectional;

import io.sanzharss.relationship.domain.many_to_many.unidirectional.Author;
import io.sanzharss.relationship.repository.many_to_many.unidirectionalRepository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author save(Author author){
        return authorRepository.save(author);
    }

    public Author update(Long id, Author updateAuthor){
        Optional<Author> optionalAuthor = authorRepository.findById(id);

        if(optionalAuthor.isPresent()){
            Author myAuthor = optionalAuthor.get();

            myAuthor.setBook(updateAuthor.getBook());
            myAuthor.setFirstName(updateAuthor.getFirstName());
            myAuthor.setLastName(updateAuthor.getLastName());

            return authorRepository.save(myAuthor);
        }else
            log.warn("Author " + id + " not found!");

        return updateAuthor;
    }

    public Author findById(Long id){
        Optional<Author> optionalAuthor = authorRepository.findById(id);

        if (optionalAuthor.isPresent()){
            Author myAuthor = optionalAuthor.get();
        }else
            log.warn("Author " + id + " not found!");

        return null;
    }

    public List<Author> findAll(){
        List<Author> authors = new LinkedList<>();
        authorRepository.findAll().forEach(authors::add);
        return authors;
    }

    public void delete(Long id){
        authorRepository.deleteById(id);
    }
}
