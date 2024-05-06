package io.sanzharss.relationship.web.one_to_many.bidirectional;

import io.sanzharss.relationship.domain.one_to_one.bidirectional.Person;
import io.sanzharss.relationship.service.one_to_one.bidirectional.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person save(@RequestBody Person person){
        return personService.save(person);
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable Long id, Person person){return personService.update(id,person);}

    @GetMapping
    public List<Person> findAll(){
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable Long id){
        return personService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        personService.delete(id);
    }
}
