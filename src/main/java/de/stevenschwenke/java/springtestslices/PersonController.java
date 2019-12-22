package de.stevenschwenke.java.springtestslices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/persons")
    public ResponseEntity<List<Person>> listPersons() {

        return new ResponseEntity<>(personService.listAllPersons(), HttpStatus.OK);
    }

}
