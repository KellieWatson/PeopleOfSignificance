package com.watsonxyz.kd.generator;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.watsonxyz.kd.model.Person;
import com.watsonxyz.kd.repository.PersonRepository;
import io.bloco.faker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


@SpringComponent
public class PersonsGenerator {
    @Bean
    public CommandLineRunner loadSampleData(PersonRepository personRepository){
        return args -> {
            Logger logger = LoggerFactory.getLogger(getClass());
            if(personRepository.count() != 0){
                logger.info("Using Existing Database");
                return;
            }
            int seed = 123;
            logger.info("Generating Persons Data");
            List<Person> persons = createSamplePersonsList();
            personRepository.saveAll(persons);
            logger.info("Generated Sample Person Data");

        };
    }
    public List<Person> createSamplePersonsList(){
        Faker faker = new Faker();
        List<Person> personList = new ArrayList();
        Person randomPerson = new Person();
        randomPerson.setFirstName(faker.name.firstName());
        randomPerson.setLastName(faker.name.lastName());
        randomPerson.setEmail(faker.internet.email());
        Person randomPerson2 = new Person();
        randomPerson2.setFirstName(faker.name.firstName());
        randomPerson2.setLastName(faker.name.lastName());
        randomPerson2.setEmail(faker.internet.email());
        personList.add(randomPerson);
        personList.add(randomPerson2);
        return personList;
    }
}
