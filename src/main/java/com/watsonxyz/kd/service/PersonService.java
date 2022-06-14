package com.watsonxyz.kd.service;

import com.watsonxyz.kd.model.Person;
import com.watsonxyz.kd.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public List<Person> findAllPersons(String filter){
        if (filter == null || filter.isEmpty()) {
            return personRepository.findAll();
        } else {
            return personRepository.search(filter);
        }
    }
    public Long countPersons(){
        return personRepository.count();
    }
}
