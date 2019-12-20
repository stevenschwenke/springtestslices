package de.stevenschwenke.java.springtestslices;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DudeServiceImpl implements DudeService {

    private final PersonRepository personRepository;

    public DudeServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> listAllPersons() {
        return personRepository.findAll();
    }
}
