package agenda.controllers;

import agenda.entity.PersonEntity;
import agenda.repository.PersonRepository;
import agenda.request.PersonRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/persons")
public class Person {

    private final PersonRepository personRepository;

    @GetMapping
    public ResponseEntity allPerson(){

        Iterable<PersonEntity> personEntity = personRepository.findAll();

        return ResponseEntity.ok().body(personEntity);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity getPerson(@PathVariable(value = "id") final Long id) {

        Optional<PersonEntity> personEntity = personRepository.findById(id);

        if (personEntity.isPresent()) {
            return ResponseEntity.ok().body(personEntity.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity postPerson(@RequestBody final PersonRequest personRequest) {

        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(personRequest.getName());
        personEntity.setBirthDate(personRequest.getBirthDate());
        personEntity.setSex(personRequest.getSex().getValue());

        personRepository.save(personEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletePerson(@PathVariable(value = "id") final Long id) {

        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(id);

        personRepository.delete(personEntity);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity putPerson(@PathVariable(value = "id") final Long id,
                                    @RequestBody final PersonRequest personRequest) {

        Optional<PersonEntity> personEntity = personRepository.findById(id);

        if (personEntity.isPresent()) {
            PersonEntity person = personEntity.get();
            person.setName(personRequest.getName());
            person.setBirthDate(personRequest.getBirthDate());
            person.setSex(personRequest.getSex().getValue());
            personRepository.save(person);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
