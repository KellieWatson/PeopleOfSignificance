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

    public void savePerson(Person person){
        if(person == null){
            System.err.println("The person is null. Are you sure the application has been properly connected to the form?");
        }
        else{
            personRepository.saveAndFlush(person);
        }
    }
    public void deletePerson(Person person){
        personRepository.delete(person);
    }
}
