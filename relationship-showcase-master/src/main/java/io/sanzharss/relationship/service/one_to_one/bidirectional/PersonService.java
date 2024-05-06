package io.sanzharss.relationship.service.one_to_one.bidirectional;

import io.sanzharss.relationship.domain.one_to_one.bidirectional.Person;
import io.sanzharss.relationship.repository.one_to_one.bidirectionalRepository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PersonService {

    @Autowired
    private final PersonRepository personRepository;


    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person save(Person person){
        return personRepository.save(person);
    }

    public Person update(Long id, Person updatePerson){
        Optional<Person> optionalPerson = personRepository.findById(id);

        if(optionalPerson.isPresent()){
            Person myPerson = optionalPerson.get();

            myPerson.setFingerprint(updatePerson.getFingerprint());
            myPerson.setFirstName(updatePerson.getFirstName());
            myPerson.setLastName(updatePerson.getLastName());

            return myPerson;
        }else
            log.warn("Person " + id + " not found!");
        return null;
    }

    public Person findById(Long id){
        Optional<Person> optionalPerson = personRepository.findById(id);

        if(optionalPerson.isPresent()){
            return optionalPerson.get();
        }else
            log.warn("Person " + id + " not found!");
        return null;
    }

    public List<Person> findAll(){
        List<Person> persons = new LinkedList<>();
        personRepository.findAll().forEach(persons::add);
        return persons;
    }

    public void delete(Long id){
        personRepository.deleteById(id);
    }


}
