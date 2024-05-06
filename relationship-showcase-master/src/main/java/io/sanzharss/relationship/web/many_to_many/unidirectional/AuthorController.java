package io.sanzharss.relationship.web.many_to_many.unidirectional;

import io.sanzharss.relationship.domain.many_to_many.unidirectional.Author;
import io.sanzharss.relationship.service.many_to_many.unidirectional.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    public final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public Author save(@RequestBody Author author){
        return authorService.save(author);
    }

    @PutMapping("/{id}")
    public Author update(@PathVariable Long id, @RequestBody Author author){
        return authorService.update(id,author);
    }

    @GetMapping
    public List<Author> findAll(){
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable Long id){
        return authorService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        authorService.delete(id);
    }
}
